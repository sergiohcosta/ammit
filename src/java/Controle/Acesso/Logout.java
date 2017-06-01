package Controle.Acesso;

import Controle.Usuario.*;
import Controle.Logica;
import DAO.UsuarioDAO;
import beans.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sergio
 */
public class Logout implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        System.out.println("Executando a logica  " + this.getClass().getName() + " ...");

        HttpSession session = req.getSession();
        session.removeAttribute("funcionario");
        session.invalidate();

        return "Controle?logica=Acesso.Login&msg=logout";

    }
}