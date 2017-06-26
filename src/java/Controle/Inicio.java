package Controle;

import DAO.QuestaoDAO;
import DAO.RespostaDAO;
import beans.Questao;
import beans.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Inicio  implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        System.out.println("Executando a logica " + this.getClass().getName() + " ...");
        HttpSession session = req.getSession(true);
        Usuario u = (Usuario) session.getAttribute("usuario");
        RespostaDAO rdao=new RespostaDAO();
        
        List<Questao> questoes = new QuestaoDAO().listarQuestoes(u.getId());
        int qtdRespostas=0;
        for(Questao questao:questoes)
            qtdRespostas+=rdao.listarRespostas(questao.getId()).size();
        
        
        req.setAttribute("qtdQuestao", questoes.size());
        req.setAttribute("qtdRespostas", qtdRespostas);

        
        return "/index.jsp";
        
    }
    
    
}
