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
public class Ammit implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        System.out.println("Executando a logica  " + this.getClass().getName() + " ...");
        
        String seed = req.getParameter("seed");
        int qtde = Integer.parseInt(req.getParameter("qtde"));
        
        req.setAttribute("gerado", "Você pediu para gerar " + qtde + " para a seed " + seed);
        
        return "/pages/casoteste/ammit.jsp";

    }

}
