/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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

    private String titulo = "";

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
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
    
}
