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
    private PreparedStatement stmtListar, stmtListarAluno,stmtListarQuestao, stmtObtemResposta, stmtInserir, stmtLastId,stmtRemover, stmtCorrigir;

    public RespostaDAO() throws SQLException, ClassNotFoundException {
        con = ConnectionFactory.getConnection();

        stmtLastId = con.prepareStatement("select LAST_INSERT_ID() as lastId");

        stmtListar = con.prepareStatement(
                "SELECT * FROM resposta"
        );
        
        stmtListarAluno = con.prepareStatement(
                "SELECT * FROM resposta where aluno=?"
        );
        
        stmtListarQuestao = con.prepareStatement(
                "SELECT * FROM resposta where questao=?"
        );
        
        stmtObtemResposta = con.prepareStatement(
                "SELECT * FROM resposta WHERE id=?"
        );

        stmtInserir = con.prepareStatement(
                "INSERT INTO resposta ("
                + "aluno, questao, codfonte, estado"
                + ") VALUES ("
                + "?, ?, ?, ?"
                + ")"
        );
        
        stmtRemover = con.prepareStatement(
                "DELETE FROM resposta WHERE id=?"
        );
        
        stmtCorrigir = con.prepareStatement(
                "UPDATE resposta SET estado=? WHERE id=?"
        );

    }
    
    public int corrigeResposta(Resposta r) throws SQLException{
        stmtCorrigir.setInt(1, r.getEstado());
        stmtCorrigir.setInt(2, r.getId());
        
        return stmtCorrigir.executeUpdate();
    }
    
    public List<Resposta> listarRespostas() throws SQLException {

        List<Resposta> listaRespostas = new ArrayList<>();

        ResultSet rs1 = stmtListar.executeQuery();

        while (rs1.next()) {
            Resposta q = new Resposta();
            q.setId(rs1.getInt("id"));
            q.setAluno(rs1.getInt("aluno"));
            q.setQuestao(rs1.getInt("questao"));
            q.setCodigofonte(rs1.getBinaryStream("codfonte"));
            q.setEstado(rs1.getInt("estado"));
            
            listaRespostas.add(q);

        }

        return listaRespostas;

    }
    
    public List<Resposta> listarRespostasAluno(int aId) throws SQLException {

        List<Resposta> listaRespostas = new ArrayList<>();
        stmtListarAluno.setInt(1, aId);
        
        ResultSet rs1 = stmtListarAluno.executeQuery();

        while (rs1.next()) {
            Resposta q = new Resposta();
            q.setId(rs1.getInt("id"));
            q.setAluno(rs1.getInt("aluno"));
            q.setQuestao(rs1.getInt("questao"));
            q.setCodigofonte(rs1.getBinaryStream("codfonte"));
            q.setEstado(rs1.getInt("estado"));
            
            listaRespostas.add(q);

        }

        return listaRespostas;

    }

    
    public List<Resposta> listarRespostas(int qId) throws SQLException {

        List<Resposta> listaRespostas = new ArrayList<>();
        stmtListarQuestao.setInt(1, qId);
        
        ResultSet rs1 = stmtListarQuestao.executeQuery();

        while (rs1.next()) {
            Resposta q = new Resposta();
            q.setId(rs1.getInt("id"));
            q.setAluno(rs1.getInt("aluno"));
            q.setQuestao(rs1.getInt("questao"));
            q.setCodigofonte(rs1.getBinaryStream("codfonte"));
            q.setEstado(rs1.getInt("estado"));
            
            listaRespostas.add(q);

        }

        return listaRespostas;

    }

    public Resposta obtemResposta(int id) throws SQLException {

        stmtObtemResposta.setInt(1, id);

        ResultSet rs1 = stmtObtemResposta.executeQuery();

        Resposta q = new Resposta();

        if (rs1.next()) {
            q.setId(rs1.getInt("id"));
            q.setAluno(rs1.getInt("aluno"));
            q.setQuestao(rs1.getInt("questao"));
            q.setCodigofonte(rs1.getBinaryStream("codfonte"));
            q.setEstado(rs1.getInt("estado"));
        }

        return q;
    }

    public int insereResposta(Resposta q)
            throws SQLException {
        // INSERT INTO resposta (aluno, questao, codfonte, estado)
        // VALUES              (1,      2,         3    , 4    )

        stmtInserir.setInt(1, q.getAluno());
        stmtInserir.setInt(2, q.getQuestao());
        stmtInserir.setBlob(3, q.getCodigofonte());
        stmtInserir.setInt(4, q.getEstado());

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
