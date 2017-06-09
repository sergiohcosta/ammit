package Controle.Casoteste;

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

/**
 *
 * @author sergio
 */
public class Gerenciar implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        System.out.println("Executando a logica  " + this.getClass().getName() + " ...");
        
        int questaoId = Integer.parseInt(req.getParameter("q"));
        
        QuestaoDAO qDao = new QuestaoDAO();
        Questao q = qDao.obtemQuestao(questaoId);
        
        List<Usuario> usuarios = new ArrayList<>();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        usuarios = usuarioDao.listarUsuarios();
        
        req.setAttribute("q", q);
        
        return "/pages/casoteste/gerenciar.jsp";

    }

}
