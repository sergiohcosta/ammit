package DAO;

import beans.Casoteste;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CasotesteDAO {

    private Connection con = null;
    private PreparedStatement stmtListar, stmtAtualizar, stmtAtualizarSemUpload, stmtObtemCasoteste, stmtInserir, stmtLastId, stmtRemover;

    public CasotesteDAO() throws SQLException, ClassNotFoundException {
        con = ConnectionFactory.getConnection();

        stmtLastId = con.prepareStatement("select LAST_INSERT_ID() as lastId");

        stmtListar = con.prepareStatement(
                "SELECT * FROM casoteste WHERE questao=?"
        );
        stmtAtualizar = con.prepareStatement(
                "UPDATE casoteste SET "
                + "titulo = ?"
                + ",conteudo = ?"
                + ",questao = ?"
                + ",ammit_seed = ?"
                + ",ammit_qtde = ?"
                + ",entrada = ?"
                + ",saida = ?"
                + ",codigofonte = ?"
                + ",codigofonte_linguagem = ?"
                + " WHERE id = ?"
        );
        stmtAtualizarSemUpload = con.prepareStatement(
                "UPDATE casoteste SET "
                + "titulo = ?"
                + ",conteudo = ?"
                + ",questao = ?"
                + ",ammit_seed = ?"
                + ",ammit_qtde = ?"
                + ",entrada = ?"
                + ",saida = ?"
                + ",codigofonte_linguagem = ?"
                + " WHERE id = ?"
        );
        stmtObtemCasoteste = con.prepareStatement(
                "SELECT * FROM casoteste WHERE id=?"
        );

        stmtInserir = con.prepareStatement(
                "INSERT INTO casoteste ("
                + "titulo, conteudo, questao, ammit_seed, ammit_qtde,entrada,saida,codigofonte,codigofonte_linguagem"
                + ") VALUES ("
                + "?, ?, ?, ?, ?, ?, ?, ?, ?"
                + ")"
        );

        stmtRemover = con.prepareStatement(
                "DELETE FROM casoteste WHERE id=?"
        );

    }

    public List<Casoteste> listarCasosteste(int questaoId) throws SQLException {

        List<Casoteste> listaCasosteste = new ArrayList<>();

        stmtListar.setInt(1, questaoId);
        ResultSet rs1 = stmtListar.executeQuery();

        while (rs1.next()) {
            Casoteste ct = new Casoteste();
            ct.setId(rs1.getInt("id"));
            ct.setTitulo(rs1.getString("titulo"));
            ct.setConteudo(rs1.getString("conteudo"));
            ct.setQuestao(rs1.getInt("questao"));
            ct.setAmmit_seed(rs1.getString("ammit_seed"));
            ct.setAmmit_qtde(rs1.getInt("ammit_qtde"));
            ct.setEntrada(rs1.getString("entrada"));
            ct.setSaida(rs1.getString("Saida"));
            ct.setCodigofonte(rs1.getBinaryStream("codigofonte"));

            listaCasosteste.add(ct);

        }

        return listaCasosteste;

    }

    public int alteraCasoteste(Casoteste ct)
            throws SQLException {
        /* 
               1 + "titulo = ?"
               2 + ",conteudo = ?"
               3  + ",questao = ?"
               4 + ",ammit_seed = ?"
               5 + ",ammit_qtde = ?"
               6 + ",entrada = ?"
               7 + ",saida = ?"
               8 + ",codigofonte = ?"
               9 + ",codigofonte_linguagem = ?"
              10 + " WHERE id = ?" */

        stmtAtualizar.setString(1, ct.getTitulo());
        stmtAtualizar.setString(2, ct.getConteudo());
        stmtAtualizar.setInt(3, ct.getQuestao());
        stmtAtualizar.setString(4, ct.getAmmit_seed());
        stmtAtualizar.setInt(5, ct.getAmmit_qtde());
        stmtAtualizar.setString(6, ct.getEntrada());
        stmtAtualizar.setString(7, ct.getSaida());
        stmtAtualizar.setBlob(8, ct.getCodigofonte());
        stmtAtualizar.setString(9, ct.getCodigofonte_linguagem());
        stmtAtualizar.setInt(10, ct.getId());

        System.out.println(stmtAtualizar);

        return stmtAtualizar.executeUpdate();

    }

    public int alteraCasotesteSemUpload(Casoteste ct)
            throws SQLException {
        /* 
               1 + "titulo = ?"
               2 + ",conteudo = ?"
               3  + ",questao = ?"
               4 + ",ammit_seed = ?"
               5 + ",ammit_qtde = ?"
               6 + ",entrada = ?"
               7 + ",saida = ?"
               8 + ",codigofonte_linguagem = ?"
               9 + " WHERE id = ?" */

        stmtAtualizarSemUpload.setString(1, ct.getTitulo());
        stmtAtualizarSemUpload.setString(2, ct.getConteudo());
        stmtAtualizarSemUpload.setInt(3, ct.getQuestao());
        stmtAtualizarSemUpload.setString(4, ct.getAmmit_seed());
        stmtAtualizarSemUpload.setInt(5, ct.getAmmit_qtde());
        stmtAtualizarSemUpload.setString(6, ct.getEntrada());
        stmtAtualizarSemUpload.setString(7, ct.getSaida());
        stmtAtualizarSemUpload.setString(8, ct.getCodigofonte_linguagem());
        stmtAtualizarSemUpload.setInt(9, ct.getId());

        System.out.println(stmtAtualizarSemUpload);

        return stmtAtualizarSemUpload.executeUpdate();

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
            ct.setAmmit_seed(rs1.getString("ammit_seed"));
            ct.setAmmit_qtde(rs1.getInt("ammit_qtde"));
            ct.setEntrada(rs1.getString("entrada"));
            ct.setSaida(rs1.getString("saida"));
            ct.setCodigofonte(rs1.getBinaryStream("codigofonte"));
            ct.setCodigofonte_linguagem(rs1.getString("codigofonte_linguagem"));
        }

        return ct;
    }

    public int insereCasoteste(Casoteste ct)
            throws SQLException {
        // "INSERT INTO casoteste ("
        //        + "titulo, conteudo, questao, ammit_seed, ammit_qtde,entrada,saida,codigofonte"
        //        + ") VALUES ("
        //        + "?, ?, ?, ?, ?, ?, ?, ?"
        //        + ")"

        stmtInserir.setString(1, ct.getTitulo());
        stmtInserir.setString(2, ct.getConteudo());
        stmtInserir.setInt(3, ct.getQuestao());
        stmtInserir.setString(4, ct.getAmmit_seed());
        stmtInserir.setInt(5, ct.getAmmit_qtde());
        stmtInserir.setString(6, ct.getEntrada());
        stmtInserir.setString(7, ct.getSaida());
        stmtInserir.setBlob(8, ct.getCodigofonte());
        stmtInserir.setString(9, ct.getCodigofonte_linguagem());

        System.out.println(stmtInserir);

        stmtInserir.executeUpdate();

        ResultSet rs1 = stmtLastId.executeQuery();
        rs1.next();
        return rs1.getInt("lastId");

    }

    public void removerCasoteste(Casoteste ct) throws SQLException {
        stmtRemover.setInt(1, ct.getId());

        System.out.println(stmtRemover);

        stmtRemover.executeUpdate();
    }

}
