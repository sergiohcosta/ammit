package DAO;

import beans.Casoteste;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CasotesteDAO {

    private Connection con = null;
    private PreparedStatement stmtListar, stmtAtualizar, stmtObtemCasoteste, stmtInserir, stmtLastId,stmtRemover;

    public CasotesteDAO() throws SQLException, ClassNotFoundException {
        con = ConnectionFactory.getConnection();

        stmtLastId = con.prepareStatement("select LAST_INSERT_ID() as lastId");

        stmtListar = con.prepareStatement(
                "SELECT * FROM casoteste"
        );
        stmtAtualizar = con.prepareStatement(
                "UPDATE casoteste SET "
                + "titulo = ?"
                + ",conteudo = ?"
                + ",questao = ?"
                + " WHERE id = ?"
        );
        stmtObtemCasoteste = con.prepareStatement(
                "SELECT * FROM casoteste WHERE id=?"
        );

        stmtInserir = con.prepareStatement(
                "INSERT INTO casoteste ("
                + "titulo, conteudo, questao"
                + ") VALUES ("
                + "?, ?, ?"
                + ")"
        );
        
        stmtRemover = con.prepareStatement(
                "DELETE FROM casoteste WHERE id=?"
        );

    }

    public List<Casoteste> listarCasosteste() throws SQLException {

        List<Casoteste> listaCasosteste = new ArrayList<>();

        ResultSet rs1 = stmtListar.executeQuery();

        while (rs1.next()) {
            Casoteste ct = new Casoteste();
            ct.setId(rs1.getInt("id"));
            ct.setTitulo(rs1.getString("titulo"));
            ct.setConteudo(rs1.getString("conteudo"));
            ct.setQuestao(rs1.getInt("questao"));

            listaCasosteste.add(ct);

        }

        return listaCasosteste;

    }

    public int alteraCasoteste(Casoteste ct)
            throws SQLException {
        /* 
     1 titulo = ?"
     2 + ",conteudo = ?"
     3 + ",questao = ?"
     4 + " WHERE id = ?" */

        stmtAtualizar.setString(1, ct.getTitulo());
        stmtAtualizar.setString(2, ct.getConteudo());
        stmtAtualizar.setInt(3, ct.getQuestao());
        stmtAtualizar.setInt(4, ct.getId());

        System.out.println(stmtAtualizar);

        return stmtAtualizar.executeUpdate();

    }

    public Casoteste obtemCasoteste(int id) throws SQLException {

        stmtObtemCasoteste.setInt(1, id);

        ResultSet rs1 = stmtObtemCasoteste.executeQuery();

        Casoteste ct = new Casoteste();

        if (rs1.next()) {
            ct.setId(rs1.getInt("id"));
            ct.setConteudo(rs1.getString("conteudo"));
            ct.setTitulo(rs1.getString("titulo"));
            ct.setQuestao(rs1.getInt("questao"));
        }

        return ct;
    }

    public int insereCasoteste(Casoteste ct)
            throws SQLException {
        // INSERT INTO casoteste (titulo, conteudo, questao)
        // VALUES              (1,      2,         3        )

        stmtInserir.setString(1, ct.getTitulo());
        stmtInserir.setString(2, ct.getConteudo());
        stmtInserir.setInt(3, ct.getQuestao());

        System.out.println(stmtInserir);

        stmtInserir.executeUpdate();

        ResultSet rs1 = stmtLastId.executeQuery();
        rs1.next();
        return rs1.getInt("lastId");

    }    

    public void removerCasoteste(Casoteste ct) throws SQLException  {
        stmtRemover.setInt(1, ct.getId());

        System.out.println(stmtRemover);

        stmtRemover.executeUpdate();
    }

}
