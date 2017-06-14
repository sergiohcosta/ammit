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

import Input.*;

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
        
        InputGenerator ig = new InputGenerator(seed);
        
        String output = "";
        
        for(int i=0; i<qtde; i++) {
            output += "\n" + ig.generate();
        }
        
        
        req.setAttribute("gerado", output);
        
        return "/pages/casoteste/ammit.jsp";

    }

}
