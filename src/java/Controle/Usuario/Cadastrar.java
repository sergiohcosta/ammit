package Controle.Usuario;

import Controle.Logica;
import DAO.UsuarioDAO;
import beans.Usuario;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sergio
 */
public class Cadastrar implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        System.out.println("Executando a logica " + this.getClass().getName() + " ...");
        
        UsuarioDAO fDao = new UsuarioDAO();

        // So tenta processar informacoes se for um POST
        if (req.getMethod().equals("POST")) {

            // seta a mensagem como cadastrado como sucesso     
            req.setAttribute("status", "1");
            ArrayList<String> msgErro = new ArrayList<>();

            // verificacao server-side do POST
            // TODO: implementar validacao nos campos que faltam e checar se há melhorias possíveis nas validações
            String perfil = req.getParameter("perfil");

            if (!perfil.equals("Atendente") && !perfil.equals("Nutricionista") && !perfil.equals("Gerente")) {
                req.setAttribute("status", "0");
                req.setAttribute("errNome", "1");
                msgErro.add("Selecione um perfil válido para o funcionário");
            }

            String nome = req.getParameter("nome");

            if (nome.length() < 3) {
                req.setAttribute("status", "0");
                req.setAttribute("errNome", "1");
                msgErro.add("O campo Nome deve conter pelo menos 3 caracteres");
            }

            String email = req.getParameter("email");

            if (email.length() < 3) {
                req.setAttribute("status", "0");
                req.setAttribute("errEmail", "1");
                msgErro.add("O campo <b>Email</b> deve ser um endereço de email válido");
            }

            String senha = req.getParameter("senha");

            if (senha.length() < 3) {
                req.setAttribute("status", "0");
                req.setAttribute("errSenha", "1");
                msgErro.add("O campo <b>Senha</b> deve ser preenchido");
            }

            req.setAttribute("msgErro", msgErro);
            System.out.println("Erros encontrados: " + msgErro.size());

            if (req.getAttribute("status").equals("1")) {
                // TODO: grave no banco
                System.out.println("Gravar no banco");
                
                Usuario p = new Usuario();

                p.setId(Integer.parseInt(req.getParameter("id")));
                p.setPerfil(perfil);
                p.setNome(nome);
                p.setEmail(email);
                p.setSenha(senha);

                if (p.getId() == 0) {
                    System.out.println("Cadastrando: " + p);
                    fDao.insereUsuario(p);

                } else {

                    System.out.println("Editando: " + p);
                    fDao.alteraUsuario(p);
                }
            }
        } else {

            String op = (String) req.getParameter("op");
            if ("editar".equals(op)) {
                
                req.setAttribute("p", fDao.obtemUsuario(Integer.valueOf(req.getParameter("pId"))));

            }

        }

        return "/pages/funcionario/cadastrar.jsp";

    }

}
