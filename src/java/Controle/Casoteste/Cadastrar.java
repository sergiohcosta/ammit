package Controle.Casoteste;

import Controle.Questao.*;
import beans.Questao;
import beans.Usuario;

import Controle.Usuario.*;
import Controle.Logica;
import DAO.CasotesteDAO;

import DAO.UsuarioDAO;
import DAO.QuestaoDAO;
import beans.Casoteste;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sergio
 */
public class Cadastrar implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        System.out.println("Executando a logica " + this.getClass().getName() + " ...");

        //UsuarioDAO uDao = new UsuarioDAO();
        //req.setAttribute("listaProfessores", uDao.listarProfessores());
        QuestaoDAO qDao = new QuestaoDAO();
        CasotesteDAO ctDao = new CasotesteDAO();
        Casoteste cteste;
        
        Questao q;
        int questaoId = 0;

        try {
            questaoId = Integer.parseInt(req.getParameter("qId"));
            qDao = new QuestaoDAO();
            q = qDao.obtemQuestao(questaoId);

            if (q.getId() < 1) {
                throw new NumberFormatException();
            }
            
            req.setAttribute("q", q);

        } catch (NumberFormatException e) {
            req.setAttribute("status", 0);
            req.setAttribute("msgErro", "Selecione uma questão para gerenciar seus Casos de Teste");
            req.setAttribute("redirTo", "QuestaoGerenciar");
            return "/pages/redirect.jsp";
        }

        // So tenta processar informacoes se for um POST
        if (req.getMethod().equals("POST")) {

            // seta a mensagem como cadastrado como sucesso     
            req.setAttribute("status", "1");
            ArrayList<String> msgErro = new ArrayList<>();

            // verificacao server-side do POST
            // TODO: implementar validacao nos campos que faltam e checar se há melhorias possíveis nas validações
            String titulo = req.getParameter("titulo");

            if (titulo.length() < 3) {
                req.setAttribute("status", "0");
                req.setAttribute("errTitulo", "1");
                msgErro.add("O campo Título deve conter pelo menos 3 caracteres");
            }

            String conteudo = req.getParameter("conteudo");

            if (conteudo.length() < 3) {
                req.setAttribute("status", "0");
                req.setAttribute("errConteudo", "1");
                msgErro.add("O campo <b>Conteudo</b> deve conter pelo menos 3 caracteres");
            }
            
            String ammit_seed = req.getParameter("ammit_seed");

            if (ammit_seed.length() < 3) {
                req.setAttribute("status", "0");
                req.setAttribute("errAmmitSeed", "1");
                msgErro.add("O campo <b>Sintaxe Ammit</b> deve conter pelo menos 3 caracteres");
            }
            
            String ammit_qtde = req.getParameter("ammit_qtde");

            if (ammit_qtde.length() < 3) {
                req.setAttribute("status", "0");
                req.setAttribute("errAmmitQtde", "1");
                msgErro.add("A <b>Quantidade de linhas</b> deve ser pelo menos 1");
            }
            
            String entrada = req.getParameter("entrada");
            // TODO: validar isso somente se entrada manual for selecionada
            if (entrada.length() < 3) {
                req.setAttribute("status", "0");
                req.setAttribute("errEntrada", "1");
                msgErro.add("O campo <b>Entrada</b> deve conter pelo menos 3 caracteres");
            }
            
            String saida = req.getParameter("saida");
            // TODO: validar isso somente se saida manual for selecionada
            if (saida.length() < 3) {
                req.setAttribute("status", "0");
                req.setAttribute("errEntrada", "1");
                msgErro.add("O campo <b>Saída</b> deve conter pelo menos 3 caracteres");
            }

            req.setAttribute("msgErro", msgErro);
            System.out.println("Erros encontrados: " + msgErro.size());

            if (req.getAttribute("status").equals("1")) {

                cteste = new Casoteste();

                cteste.setId(questaoId);
                cteste.setQuestao(questaoId);
                cteste.setTitulo(titulo);
                cteste.setConteudo(conteudo);


                if (questaoId == 0) {
                    System.out.println("Cadastrando: " + q);
                    int lastId = ctDao.insereCasoteste(cteste);
                    //q.setId(lastId);

                    // em vez de mandar de volta pro formulario, manda pra parte 2 pra cadastrar casos de teste
                    //req.setAttribute("q", q);
                    //req.setAttribute("redirTo", "CasoTesteGerenciar");
                    //return "/pages/redirect.jsp";

                } else {

                    System.out.println("Editando: " + q);
                    ctDao.alteraCasoteste(cteste);
                }
                
            }
        } else {

            String op = (String) req.getParameter("op");
            if ("editar".equals(op)) {

                req.setAttribute("p", ctDao.obtemCasoteste(Integer.valueOf(req.getParameter("qId"))));

            }

        }

        return "/pages/casoteste/cadastrar.jsp";

    }

}
