package Controle.Casoteste;

import Controle.Logica;
import DAO.CasotesteDAO;
import DAO.QuestaoDAO;
import beans.Casoteste;

import beans.Questao;
import beans.Usuario;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Gerenciar implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        System.out.println("Executando a logica  " + this.getClass().getName() + " ...");
        try {
            int questaoId = Integer.parseInt(req.getParameter("qId"));

            if (questaoId < 1) {
                throw new NumberFormatException();
            }

            Questao q = new Questao();
            QuestaoDAO qDao = new QuestaoDAO();
            q = qDao.obtemQuestao(questaoId);
            req.setAttribute("q", q);

            HttpSession session = req.getSession(true);
            Usuario u = (Usuario) session.getAttribute("usuario");

            // impede chamar questões que não são do professor logado por GET
            if ("Professor".equals(u.getPerfil()) && u.getId() != q.getProfessor()) {
                req.setAttribute("status", 2);
                req.setAttribute("redirTo", "QuestaoGerenciar");
                return "/redirect.jsp";
            }

            List<Casoteste> casosteste = new ArrayList<>();
            CasotesteDAO ctDao = new CasotesteDAO();

            casosteste = ctDao.listarCasosteste(questaoId);

            req.setAttribute("casosteste", casosteste);
            req.setAttribute("status", req.getParameter("status"));
            req.setAttribute("msg", req.getParameter("msg"));

            return "/pages/casoteste/gerenciar.jsp";

        } catch (NumberFormatException e) {
            req.setAttribute("status", 0);
            req.setAttribute("msg", "Selecione uma questão para gerenciar seus Casos de Teste");
            req.setAttribute("redirTo", "QuestaoGerenciar");
            return "/redirect.jsp";
        }

    }

}
