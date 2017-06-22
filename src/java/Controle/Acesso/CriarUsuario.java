/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Acesso;
import Controle.Logica;
import DAO.UsuarioDAO;
import beans.Usuario;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Renam
 */
public class CriarUsuario implements Logica {
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        System.out.println("Executando a logica  " + this.getClass().getName() + " ...");
        
        String jspRetorno = "/pages/acesso/criarusuario.jsp";
        
        UsuarioDAO fDao = new UsuarioDAO();
        
        if (req.getMethod().equals("POST")) {

            int usuarioId = 0;//Integer.parseInt(req.getParameter("id"));

            // seta a mensagem como cadastrado como sucesso     
            req.setAttribute("status", "1");
            ArrayList<String> msgErro = new ArrayList<>();

            // verificacao server-side do POST
            // TODO: implementar validacao nos campos que faltam e checar se há melhorias possíveis nas validações
            String perfil = req.getParameter("perfil");
            if (perfil == null){
                req.setAttribute("status", "0");
                req.setAttribute("errperfil", "1");
                msgErro.add("Seelcione um perfil");
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
                
                Usuario p = new Usuario();

                p.setId(usuarioId);
                p.setPerfil(perfil);
                p.setNome(nome);
                p.setEmail(email);
                p.setSenha(senha);

                if (usuarioId == 0) {
                    System.out.println("Cadastrando: " + p);
                    fDao.insereUsuario(p);

                } else {

                    System.out.println("Editando: " + p);
                    fDao.alteraUsuario(p);
                }
                req.getRequestDispatcher("Controle?logica=Acesso.Login").forward(req, res);
            }
        } else {
            System.out.println(req.getParameter("msg"));
        }

        return jspRetorno;
    }
    
}
