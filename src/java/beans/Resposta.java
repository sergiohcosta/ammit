/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.InputStream;
import java.io.Serializable;

/**
 *
 * @author Renam
 */
public class Resposta  implements Serializable {
    
    public Resposta(){}
    
    private int id = 0;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    
    
    private int questao = 0;
    
    public int getQuestao() {
        return questao;
    }

    public void setQuestao(int pId) {
        this.questao = pId;
    }
    
    private int aluno = 0;

    /**
     * @return the aluno
     */
    public int getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(int aluno) {
        this.aluno = aluno;
    }
    
    private int estado;

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    private InputStream codigofonte = null;

    /**
     * @return the codigofonte
     */
    public InputStream getCodigofonte() {
        return codigofonte;
    }

    /**
     * @param codigofonte the codigofonte to set
     */
    public void setCodigofonte(InputStream codigofonte) {
        this.codigofonte = codigofonte;
    }
}
