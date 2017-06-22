package Controle.Resposta;

import Controle.Resposta.*;
import Controle.Questao.*;
import Controle.Usuario.*;
import Controle.Logica;
import DAO.QuestaoDAO;
import DAO.UsuarioDAO;
import beans.Questao;
import beans.Resposta;
import beans.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Pesquisar implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        System.out.println("Executando a logica  " + this.getClass().getName() + " ...");

        String op = (String) req.getParameter("op");

        if ("remover".equals(op)) {
            Questao q = new Questao();
            q.setId(Integer.valueOf(req.getParameter("pId")));
            new QuestaoDAO().removerQuestao(q);
            return "/pages/questao/removido.json";
        }

        
        List<Questao> questoes = new ArrayList<>();
        questoes = new QuestaoDAO().listarQuestoes();
        req.setAttribute("questoes", questoes);

        Map professores = new UsuarioDAO().listarProfessoresArr();
        req.setAttribute("professores", professores);

        return "/pages/resposta/pesquisar.jsp";

    }

}
