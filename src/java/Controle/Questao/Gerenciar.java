package Controle.Questao;

import Controle.Logica;

import DAO.QuestaoDAO;

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

        String op = (String) req.getParameter("op");
        
        List<Questao> questoes = new ArrayList<>();
        QuestaoDAO qDao = new QuestaoDAO();

        if ("remover".equals(op)) {
            Questao q = new Questao();
            q.setId(Integer.valueOf(req.getParameter("pId")));
            qDao.removerQuestao(q);
            return "/pages/questao/removido.json";
        }

        
        HttpSession session = req.getSession(true);
        Usuario u = (Usuario) session.getAttribute("usuario");
        
        if(u==null){
            return "/auth.jsp";
        }
        
        if("Professor".equals(u.getPerfil())){
            questoes = qDao.listarQuestoes(u.getId());
        } else {
            questoes = qDao.listarQuestoes();
        }
        

        req.setAttribute("questoes", questoes);
        req.setAttribute("status", req.getParameter("status"));
        req.setAttribute("msg", req.getParameter("msg"));

        return "/pages/questao/gerenciar.jsp";

    }

}
