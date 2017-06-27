/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Resposta;

import Compilador.*;
import Controle.Logica;
import Correction.BaseSolution;
import DAO.CasotesteDAO;
import DAO.QuestaoDAO;
import DAO.RespostaDAO;
import Input.InputGenerator;
import beans.Casoteste;
import beans.Questao;
import beans.Resposta;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renam
 */
public class Corrigir implements Logica {
    
    private final String TMP="C:\\tmp\\"; //todo - alterar para caminho no servidor
    private final String CTFIM="\r?\n<--FIM-->\r?\n?";
    
    private boolean salvaArquivo(String path, InputStream src){
        try{
            File file = new File(path);
            FileOutputStream fos= new FileOutputStream(file);
            byte[] buffer = new byte[1];
            while (src.read(buffer) > 0) {
              fos.write(buffer);
            }
            fos.close();
            return true;
        }catch(Exception e){return false;}
    }
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        RespostaDAO rdao = new RespostaDAO();
        
        Resposta r = rdao.obtemResposta(Integer.parseInt(req.getParameter("rId")));
        List<Casoteste> casos = new CasotesteDAO().listarCasosteste(r.getQuestao());
        List<String> outputs = new ArrayList();
        List<String> erros = new ArrayList();
        BaseSolution b=new BaseSolution();
        
        int ctExecutados=0, ctSucesso=0;
        
        if (salvaArquivo(TMP+"aluno.c", r.getCodigofonte())){
            CodigoCompilado c=Compilador.compilar(TMP+"aluno.c");
            if(c.isSucesso()){
                //Se o código do aluno compilar começa a testar cada caso de teste
                r.setEstado(0); //considerado certo até que seja provado o contrário
                for(Casoteste caso:casos){
                    if(!caso.getAmmit_seed().isEmpty()){ ///se for um caso de teste usando Ammit
                        if (salvaArquivo(TMP+caso.getTitulo()+".c", caso.getCodigofonte())){
                            CodigoCompilado cprof=Compilador.compilar(TMP+caso.getTitulo()+".c");
                            if (cprof.isSucesso()){
                                InputGenerator ig=new InputGenerator(caso.getAmmit_seed());
                                outputs.add("Início do caso de teste "+caso.getTitulo());
                                for(int i=0; i<caso.getAmmit_qtde();i++){
                                    ctExecutados++;
                                    String x=ig.generate();
                                    boolean compSucesso=b.correct(c.getExec(), cprof.getExec(), x);
                                    if (compSucesso) ctSucesso++;
                                    outputs.add("Entradas: <"+x+"> "
                                            + "saída do código do aluno: <"+b.execute(c.getExec(), x)+"> "
                                            + "saída do código de teste: <"+b.execute(cprof.getExec(), x)+"> "
                                            + "correto: "+ (compSucesso ? "sim":"não"));
                                }
                                outputs.add("Fim do caso de teste "+caso.getTitulo());
                            }
                            else{
                                erros.add("Caso de teste "+caso.getTitulo()+" ignorado: erro ao compilar código de teste");
                                erros.add(cprof.getErros());
                            }
                        }
                        else{
                            erros.add("Caso de teste "+caso.getTitulo()+" ignorado: erro ao salvar código de teste");
                        }
                    }
                    else if(!caso.getEntrada().isEmpty()){// se for um caso de teste manual                    
                        String[] entradas=caso.getEntrada().split(CTFIM);
                        if(!caso.getSaida().isEmpty()){ //se for CTM com saídas manuais
                            String[] saidas=caso.getSaida().split(CTFIM);
                            if (saidas.length==entradas.length){
                                outputs.add("Início do caso de teste "+caso.getTitulo());
                                for(int i=0; i<entradas.length;i++){
                                    ctExecutados++;
                                    String x=entradas[i];
                                    boolean compSucesso=b.execute(c.getExec(), x).equals(saidas[i]);
                                    if (compSucesso) ctSucesso++;
                                    outputs.add("Entradas: <"+x+"> "
                                            + "saída do código do aluno: <"+b.execute(c.getExec(), x)+"> "
                                            + "saída esperada: <"+saidas[i]+"> "
                                            + "correto: "+ (compSucesso ? "sim":"não"));
                                }
                                outputs.add("Fim do caso de teste "+caso.getTitulo());
                            }
                            else{
                                erros.add("Caso de teste "+caso.getTitulo()+" ignorado: o número de saídas difere do número de entradas");
                            }
                        }
                        else if (salvaArquivo(TMP+caso.getTitulo()+".c", caso.getCodigofonte())){ //se for CTM com código para comparar
                            CodigoCompilado cprof=Compilador.compilar(TMP+caso.getTitulo()+".c");
                            if (cprof.isSucesso()){
                                outputs.add("Início do caso de teste "+caso.getTitulo());
                                for(int i=0; i<entradas.length;i++){
                                    ctExecutados++;
                                    String x=entradas[i];
                                    boolean compSucesso=b.correct(c.getExec(), cprof.getExec(), x);
                                    if (compSucesso) ctSucesso++;
                                    outputs.add("Entradas: <"+x+"> "
                                            + "saída do código do aluno: <"+b.execute(c.getExec(), x)+"> "
                                            + "saída do código de teste: <"+b.execute(cprof.getExec(), x)+"> "
                                            + "correto: "+ (compSucesso ? "sim":"não"));
                                }
                                outputs.add("Fim do caso de teste "+caso.getTitulo());
                            }
                            else{
                                erros.add("Caso de teste "+caso.getTitulo()+" ignorado: erro ao compilar código de teste");
                            }
                        }
                        else{//se não for nenhum dos dois, é um erro
                            erros.add("Caso de teste "+caso.getTitulo()+" ignorado: saídas do caso de teste são inválidas");
                        }
                    }
                    else{//se não for nenhum dos dois, é um erro
                        erros.add("Caso de teste "+caso.getTitulo()+" ignorado: o caso de teste é inválido");
                    }
                }
            }
            else{
                erros.add("O código submetido não compila");
                erros.add(c.getErros());
                r.setEstado(1); //erro de compilação código do aluno
            }
        }
        else{
            erros.add("Ocorreu um erro interno. Tente novamente");
            r.setEstado(-3); //erro de arquivo no servidor
        }
        if(r.getEstado()==0){
            if(ctExecutados==0){
                erros.add("Nenhum caso de teste executado. Informe seu professor");
                r.setEstado(-4);
            }
            else if(ctExecutados==ctSucesso){
                outputs.add("Resposta correta! ("+ctExecutados+" casos de teste)");
            }
            else{
                erros.add("Resposta incorreta! ("+ctSucesso+" casos de teste certos em "+ctExecutados+" casos testados)");
                r.setEstado(2);
            }
        }
        
        if (erros.size()==0) erros.add("Nenhum erro encontrado");
        if (outputs.size()==0) outputs.add("Nenhum resultado a exibir");
        
        rdao.corrigeResposta(r);
        
        req.setAttribute("outputs", outputs);
        req.setAttribute("erros", erros);
        req.setAttribute("status", r.getEstado());
        
        return "/pages/resposta/corrigir.jsp";
    }

    
}
