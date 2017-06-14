package beans;

import java.io.Serializable;

public class Casoteste implements Serializable {

    public Casoteste() {

    }

    private int id = 0;

    public int getId() {
        return id;
    }

    public void setId(int casotesteId) {
        this.id = casotesteId;
    }

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

    public void setQuestao(int qId) {
        this.questao = qId;
    }
    
    private String conteudo = "";

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

}
