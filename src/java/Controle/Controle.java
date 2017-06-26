package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sergio
 */
@WebServlet(name = "Controle", urlPatterns = {"/Controle"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB

public class Controle extends HttpServlet {

    /**
     * Processes requests for both HTTP GET and POST methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String parametro = request.getParameter("logica");
        String nomeDaClasse = "Controle." + parametro;
        System.out.println("Classe requisitada: " + nomeDaClasse);

        try {
            Class classe = Class.forName(nomeDaClasse);

            Logica logica = (Logica) classe.newInstance();
            String pagina = logica.executa(request, response);
            System.out.println("Invocando view " + pagina);
            request.getRequestDispatcher(pagina).forward(request, response);

        } catch (ClassNotFoundException cnfEx) {
            request.setAttribute("status", 0);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("A lógica de negócio causou uma exceção", e);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
