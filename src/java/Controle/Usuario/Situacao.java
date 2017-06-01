package Controle.Usuario;

import Controle.Logica;
import DAO.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sergio
 */
public class Situacao implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        UsuarioDAO uDao = new UsuarioDAO();
        int id = Integer.parseInt(req.getParameter("pId"));
        System.out.println("Alternando situacao para o ID: " + id);
        uDao.alteraSituacao(id);
        
        return "/pages/usuario/situacao.json";

    }

}
