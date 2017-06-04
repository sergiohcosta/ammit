package beans;

import java.io.Serializable;

/**
 *
 * @author sergio
 */
public class Questao implements Serializable {

    public Questao() {

    }

    private int id = 0;

    public int getId() {
        return id;
    }

    public void setId(int pessoaId) {
        this.id = pessoaId;
    }

    private String titulo = "";

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    private int professor = 0;
    
    public int getProfessor() {
        return professor;
    }

    public void setProfessor(int pId) {
        this.professor = pId;
    }
    
    private String enunciado = "";

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

}
