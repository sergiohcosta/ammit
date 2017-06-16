/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Resposta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renam
 */
public class RespostaDAO {
    private Connection con = null;
    private PreparedStatement stmtListar, stmtAtualizar, stmtObtemResposta, stmtInserir, stmtLastId,stmtRemover;

    public RespostaDAO() throws SQLException, ClassNotFoundException {
        con = ConnectionFactory.getConnection();

        stmtLastId = con.prepareStatement("select LAST_INSERT_ID() as lastId");

        stmtListar = con.prepareStatement(
                "SELECT * FROM resposta"
        );
        stmtAtualizar = con.prepareStatement(
                "UPDATE resposta SET "
                + "titulo = ?"
                + ",aluno = ?"
                + ",questao = ?"
                + " WHERE id = ?"
        );
        stmtObtemResposta = con.prepareStatement(
                "SELECT * FROM resposta WHERE id=?"
        );

        stmtInserir = con.prepareStatement(
                "INSERT INTO resposta ("
                + "titulo, aluno, questao"
                + ") VALUES ("
                + "?, ?, ?"
                + ")"
        );
        
        stmtRemover = con.prepareStatement(
                "DELETE FROM resposta WHERE id=?"
        );

    }

    public List<Resposta> listarRespostas() throws SQLException {

        List<Resposta> listaRespostas = new ArrayList<>();

        ResultSet rs1 = stmtListar.executeQuery();

        while (rs1.next()) {
            Resposta q = new Resposta();
            q.setId(rs1.getInt("id"));
            q.setTitulo(rs1.getString("titulo"));
            q.setAluno(rs1.getInt("aluno"));
            q.setQuestao(rs1.getInt("questao"));

            listaRespostas.add(q);

        }

        return listaRespostas;

    }

    public int alteraResposta(Resposta q)
            throws SQLException {
        /* 
     1 titulo = ?"
     2 + ",aluno = ?"
     3 + ",questao = ?"
     4 + " WHERE id = ?" */

        stmtAtualizar.setString(1, q.getTitulo());
        stmtAtualizar.setInt(2, q.getAluno());
        stmtAtualizar.setInt(3, q.getQuestao());
        stmtAtualizar.setInt(4, q.getId());

        System.out.println(stmtAtualizar);

        return stmtAtualizar.executeUpdate();

    }

    public Resposta obtemResposta(int id) throws SQLException {

        stmtObtemResposta.setInt(1, id);

        ResultSet rs1 = stmtObtemResposta.executeQuery();

        Resposta q = new Resposta();

        if (rs1.next()) {
            q.setId(rs1.getInt("id"));
            q.setAluno(rs1.getInt("aluno"));
            q.setTitulo(rs1.getString("titulo"));
            q.setQuestao(rs1.getInt("questao"));
        }

        return q;
    }

    public int insereResposta(Resposta q)
            throws SQLException {
        // INSERT INTO resposta (titulo, aluno, questao)
        // VALUES              (1,      2,         3        )

        stmtInserir.setString(1, q.getTitulo());
        stmtInserir.setInt(2, q.getAluno());
        stmtInserir.setInt(3, q.getQuestao());

        System.out.println(stmtInserir);

        stmtInserir.executeUpdate();

        ResultSet rs1 = stmtLastId.executeQuery();
        rs1.next();
        return rs1.getInt("lastId");

    }    

    public void removerResposta(Resposta q) throws SQLException  {
        stmtRemover.setInt(1, q.getId());

        System.out.println(stmtRemover);

        stmtRemover.executeUpdate();
    }
}
