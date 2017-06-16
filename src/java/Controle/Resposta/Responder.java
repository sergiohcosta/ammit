/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Resposta;

import Controle.Logica;
import DAO.QuestaoDAO;
import beans.Questao;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renam
 */
public class Responder implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        System.out.println("Executando a logica  " + this.getClass().getName() + " ...");
        QuestaoDAO qDao = new QuestaoDAO();
        
        if (req.getMethod().equals("POST")) {
            
            int questaoId = Integer.parseInt(req.getParameter("id"));

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

            String enunciado = req.getParameter("enunciado");

            if (enunciado.length() < 3) {
                req.setAttribute("status", "0");
                req.setAttribute("errEnunciado", "1");
                msgErro.add("O campo <b>Enunciado</b> deve conter pelo menos 3 caracteres");
            }

            int professor = Integer.valueOf(req.getParameter("professor"));
            

            if (professor <= 0) {
                req.setAttribute("status", "0");
                req.setAttribute("errProfessor", "1");
                msgErro.add("O campo <b>Professor</b> deve ser selecionado");
            }

            req.setAttribute("msgErro", msgErro);
            System.out.println("Erros encontrados: " + msgErro.size());

            if (req.getAttribute("status").equals("1")) {
                
                Questao q = new Questao();

                q.setId(questaoId);
                q.setTitulo(titulo);
                q.setEnunciado(enunciado);
                q.setProfessor(professor);

                if (questaoId == 0) {
                    System.out.println("Cadastrando: " + q);
                    int lastId = qDao.insereQuestao(q);
                    q.setId(lastId);
                    
                    // em vez de mandar de volta pro formulario, manda pra parte 2 pra cadastrar casos de teste
                    req.setAttribute("q", q);
                    req.setAttribute("redirTo", "CasoTesteGerenciar");
                    return "/redirect.jsp";

                } else {

                    System.out.println("Editando: " + q);
                    qDao.alteraQuestao(q);
                }
            }
        } else {

            
                req.setAttribute("p", qDao.obtemQuestao(Integer.valueOf(req.getParameter("pId"))));


        }

        return "/pages/resposta/responder.jsp";

    }
}
