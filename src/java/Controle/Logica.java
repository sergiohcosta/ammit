package Controle;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sergio
 */

public interface Logica {

    /**
     *
     * @param req
     * @param res
     * @return 
     * @throws Exception
     */
    String executa(HttpServletRequest req, HttpServletResponse res) 
            throws Exception;
}
