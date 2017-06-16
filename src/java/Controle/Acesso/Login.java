package Controle.Acesso;

import Controle.Logica;
import DAO.UsuarioDAO;
import beans.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        System.out.println("Executando a logica  " + this.getClass().getName() + " ...");

        String jspRetorno = "/pages/acesso/login.jsp";

        if (req.getMethod().equals("POST")) {

            String email = (String) req.getParameter("email");
            String senha = (String) req.getParameter("senha");

            Usuario u = new Usuario();
            u.setEmail(email);
            u.setSenha(senha);

            /* isso aqui usava WS pra fazer login. agora é local mesmo
            Client client = ClientBuilder.newClient();
            Usuario retorno = client
                    .target(
                            "http://localhost:8080/cruel/webresources/WsLogin")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(f), Usuario.class); */
            
            UsuarioDAO uDao = new UsuarioDAO();

            u = uDao.autenticar(u.getEmail(), u.getSenha());
            // se a pessoa retornada tiver id != -1 e for gerente, seta sessão
            // senão, o login falhou
            if (u.getId() != -1) {
                if (!u.isSituacao()) {
                    req.setAttribute("errLogin", "3");
                }
                /* else if (!u.getPerfil().equals("Administrador")) {
                    req.setAttribute("errLogin", "2");
                }*/
                else {
                    HttpSession session = req.getSession();
                    session.setAttribute("usuario", u);
                    req.getRequestDispatcher("Controle?logica=Inicio").forward(req, res);
                } 
            } else {
                req.setAttribute("errLogin", "1");
            }

        } else {
            req.setAttribute("errLogin", req.getParameter("errLogin"));
        }

        return jspRetorno;

    }

}
