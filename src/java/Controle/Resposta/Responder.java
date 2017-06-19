/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Resposta;

import Controle.Logica;
import DAO.QuestaoDAO;
import DAO.RespostaDAO;
import beans.Questao;
import beans.Resposta;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Renam
 */
public class Responder implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        System.out.println("Executando a logica  " + this.getClass().getName() + " ...");
        QuestaoDAO qDao = new QuestaoDAO();
        RespostaDAO rDao = new RespostaDAO();
        
        if (req.getMethod().equals("POST")) {
            
            int questaoId = Integer.parseInt(req.getParameter("qid"));
            int alunoId= Integer.parseInt(req.getParameter("aid"));

            // seta a mensagem como cadastrado como sucesso     
            req.setAttribute("status", "1");
            ArrayList<String> msgErro = new ArrayList<>();

            // verificacao server-side do POST
            // TODO: implementar validacao nos campos que faltam e checar se há melhorias possíveis nas validações

            InputStream inputStream=null;
            Part filePart = req.getPart("codigofonte");
                if (filePart != null) {
                    // Mostro alguns debugs...
                    System.out.println("getName=" + filePart.getName());
                    System.out.println("getSize=" + filePart.getSize());
                    System.out.println("getContentType=" + filePart.getContentType());

                    // Se o tamanho do arquivo for vazio...
                    if (filePart.getSize() <= 0) {
                            req.setAttribute("status", "0");
                            req.setAttribute("errCodigofonte", "1");
                            msgErro.add("O <b>Código fonte</b> deve ser um arquivo de texto plano");
                        
                    } // se o tamanho do arquivo NAO for vazio...
                    else {
                        // CADASTRE ou SOBREPONHA (whatever) o arquivo upado
                        inputStream = filePart.getInputStream();
                    }
                }
            
            
            //TODO = capturar os dados de verdade

            req.setAttribute("msgErro", msgErro);
            System.out.println("Erros encontrados: " + msgErro.size());

            if (req.getAttribute("status").equals("1")) {
                
                Resposta r = new Resposta();

                r.setAluno(alunoId);
                r.setQuestao(questaoId);
                r.setEstado(-1); //questão não corrigida
                r.setCodigofonte(inputStream);
                r.setId(0);
               

                
                System.out.println("Cadastrando: " + r);
                int lastId = rDao.insereResposta(r);
                r.setId(lastId);
                req.setAttribute("rId", lastId);
                req.setAttribute("redirTo", "Corrigir");
                return "/redirect.jsp";

                
            }
        } else {

            
                req.setAttribute("p", qDao.obtemQuestao(Integer.valueOf(req.getParameter("pId"))));


        }

        return "/pages/resposta/responder.jsp";

    }
}
