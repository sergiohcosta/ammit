package Controle.Questao;

import Controle.Usuario.*;
import Controle.Logica;
import DAO.QuestaoDAO;
import DAO.UsuarioDAO;
import beans.Questao;
import beans.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Gerenciar implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        System.out.println("Executando a logica  " + this.getClass().getName() + " ...");

        String op = (String) req.getParameter("op");
        
        List<Questao> questoes = new ArrayList<>();
        QuestaoDAO qDao = new QuestaoDAO();

        if ("remover".equals(op)) {
            Questao q = new Questao();
            q.setId(Integer.valueOf(req.getParameter("pId")));
            qDao.removerQuestao(q);
            return "/pages/questao/removido.json";
        }

        

        questoes = qDao.listarQuestoes();

        req.setAttribute("questoes", questoes);
        req.setAttribute("status", req.getParameter("status"));
        req.setAttribute("msg", req.getParameter("msg"));

        return "/pages/questao/gerenciar.jsp";

    }

}
