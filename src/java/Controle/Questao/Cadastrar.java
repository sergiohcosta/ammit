package Controle.Questao;

import beans.Questao;

import Controle.Logica;

import DAO.UsuarioDAO;
import DAO.QuestaoDAO;

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
        
        UsuarioDAO uDao = new UsuarioDAO();
        QuestaoDAO qDao = new QuestaoDAO();
        
        req.setAttribute("listaProfessores", uDao.listarProfessores());
        
        // So tenta processar informacoes se for um POST
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
                    req.setAttribute("status",3);
                    req.setAttribute("redirTo", "CasoTesteGerenciar");
                    return "/redirect.jsp";

                } else {

                    System.out.println("Editando: " + q);
                    qDao.alteraQuestao(q);
                }
            }
        } else {

            String op = (String) req.getParameter("op");
            if ("editar".equals(op)) {
                
                req.setAttribute("p", qDao.obtemQuestao(Integer.valueOf(req.getParameter("pId"))));

            }

        }

        return "/pages/questao/cadastrar.jsp";

    }

}
