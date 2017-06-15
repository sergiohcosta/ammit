package Controle.Casoteste;

import Controle.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Input.*;

public class Ammit implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        System.out.println("Executando a logica  " + this.getClass().getName() + " ...");
        
        String seed = req.getParameter("seed");
        int qtde = Integer.parseInt(req.getParameter("qtde"));
        
        InputGenerator ig = new InputGenerator(seed);
        
        String output = "";
        
        for(int i=1; i<=qtde; i++) {
            output += ig.generate() + "\n<--FIM-->\n";
        }
        output = output.substring(0,output.length()-1);
        
        
        req.setAttribute("gerado", output);
        
        return "/pages/casoteste/ammit.jsp";

    }

}
