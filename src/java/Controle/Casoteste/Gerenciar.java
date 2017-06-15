package Controle.Casoteste;


import Controle.Logica;
import DAO.QuestaoDAO;

import beans.Questao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Gerenciar implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        System.out.println("Executando a logica  " + this.getClass().getName() + " ...");
        try {
            int questaoId = Integer.parseInt(req.getParameter("qId"));
            QuestaoDAO qDao = new QuestaoDAO();
            Questao q = qDao.obtemQuestao(questaoId);

            if (q.getId() < 1) {
                throw new NumberFormatException();
            }

            req.setAttribute("q", q);
            return "/pages/casoteste/gerenciar.jsp";

        } catch (NumberFormatException e) {
            req.setAttribute("status", 0);
            req.setAttribute("msgErro", "Selecione uma questão para gerenciar seus Casos de Teste");
            req.setAttribute("redirTo", "QuestaoGerenciar");
            return "/redirect.jsp";
        }

    }

}
