package DAO;

import beans.Usuario;
import beans.Questao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestaoDAO {

    private Connection con = null;
    private PreparedStatement stmtListar, stmtAtualizar, stmtObtemQuestao, stmtInserir, stmtLastId,stmtRemover,stmtListarProfessor;

    public QuestaoDAO() throws SQLException, ClassNotFoundException {
        con = ConnectionFactory.getConnection();

        stmtLastId = con.prepareStatement("select LAST_INSERT_ID() as lastId");

        stmtListar = con.prepareStatement(
                "SELECT * FROM questao"
        );
        
        stmtListarProfessor = con.prepareStatement(
                "SELECT * FROM questao WHERE professor=?"
        );
        stmtAtualizar = con.prepareStatement(
                "UPDATE questao SET "
                + "titulo = ?"
                + ",enunciado = ?"
                + ",professor = ?"
                + " WHERE id = ?"
        );
        stmtObtemQuestao = con.prepareStatement(
                "SELECT * FROM questao WHERE id=?"
        );

        stmtInserir = con.prepareStatement(
                "INSERT INTO questao ("
                + "titulo, enunciado, professor"
                + ") VALUES ("
                + "?, ?, ?"
                + ")"
        );
        
        stmtRemover = con.prepareStatement(
                "DELETE FROM questao WHERE id=?"
        );

    }

    public List<Questao> listarQuestoes() throws SQLException {

        List<Questao> listaQuestoes = new ArrayList<>();

        ResultSet rs1 = stmtListar.executeQuery();

        while (rs1.next()) {
            Questao q = new Questao();
            q.setId(rs1.getInt("id"));
            q.setTitulo(rs1.getString("titulo"));
            q.setEnunciado(rs1.getString("enunciado"));
            q.setProfessor(rs1.getInt("professor"));

            listaQuestoes.add(q);

        }

        return listaQuestoes;

    }
    
    public List<Questao> listarQuestoes(int professor) throws SQLException {

        List<Questao> listaQuestoes = new ArrayList<>();
        
        stmtListarProfessor.setInt(1, professor);
        ResultSet rs1 = stmtListarProfessor.executeQuery();

        while (rs1.next()) {
            Questao q = new Questao();
            q.setId(rs1.getInt("id"));
            q.setTitulo(rs1.getString("titulo"));
            q.setEnunciado(rs1.getString("enunciado"));
            q.setProfessor(rs1.getInt("professor"));

            listaQuestoes.add(q);

        }

        return listaQuestoes;

    }

    public int alteraQuestao(Questao q)
            throws SQLException {
        /* 
     1 titulo = ?"
     2 + ",enunciado = ?"
     3 + ",professor = ?"
     4 + " WHERE id = ?" */

        stmtAtualizar.setString(1, q.getTitulo());
        stmtAtualizar.setString(2, q.getEnunciado());
        stmtAtualizar.setInt(3, q.getProfessor());
        stmtAtualizar.setInt(4, q.getId());

        System.out.println(stmtAtualizar);

        return stmtAtualizar.executeUpdate();

    }

    public Questao obtemQuestao(int id) throws SQLException {

        stmtObtemQuestao.setInt(1, id);

        ResultSet rs1 = stmtObtemQuestao.executeQuery();

        Questao q = new Questao();

        if (rs1.next()) {
            q.setId(rs1.getInt("id"));
            q.setEnunciado(rs1.getString("enunciado"));
            q.setTitulo(rs1.getString("titulo"));
            q.setProfessor(rs1.getInt("professor"));
        }

        return q;
    }

    public int insereQuestao(Questao q)
            throws SQLException {
        // INSERT INTO questao (titulo, enunciado, professor)
        // VALUES              (1,      2,         3        )

        stmtInserir.setString(1, q.getTitulo());
        stmtInserir.setString(2, q.getEnunciado());
        stmtInserir.setInt(3, q.getProfessor());

        System.out.println(stmtInserir);

        stmtInserir.executeUpdate();

        ResultSet rs1 = stmtLastId.executeQuery();
        rs1.next();
        return rs1.getInt("lastId");

    }    

    public void removerQuestao(Questao q) throws SQLException  {
        stmtRemover.setInt(1, q.getId());

        System.out.println(stmtRemover);

        stmtRemover.executeUpdate();
    }

}
