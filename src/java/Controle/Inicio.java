package Controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class Inicio  implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        System.out.println("Executando a logica " + this.getClass().getName() + " ...");
        return "/index.jsp";
        
    }
    
    
}
