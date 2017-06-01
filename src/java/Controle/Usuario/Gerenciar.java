package Controle.Usuario;

import Controle.Logica;
import DAO.UsuarioDAO;
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
        
        List<Usuario> usuarios = new ArrayList<>();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        usuarios = usuarioDao.listarUsuarios();
        
        req.setAttribute("usuarios", usuarios);
        
        return "/pages/usuario/gerenciar.jsp";

    }

}
