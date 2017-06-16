package beans;

import java.io.InputStream;
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
    
    private String ammit_seed = "";

    public String getAmmit_seed() {
        return ammit_seed;
    }

    public void setAmmit_seed(String ammit_seed) {
        this.ammit_seed = ammit_seed;
    }
    
    private int ammit_qtde = 0;

    public int getAmmit_qtde() {
        return ammit_qtde;
    }

    public void setAmmit_qtde(int ammit_qtde) {
        this.ammit_qtde = ammit_qtde;
    }
    
    private String entrada = "";

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }
    
    private String saida = "";

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }
    
    InputStream codigofonte = null;
    
    public InputStream getCodigofonte() {
        return codigofonte;
    }

    public void setCodigofonte(InputStream codigofonte) {
        this.codigofonte = codigofonte;
    }
    
    private String codigofonte_linguagem = "";

    public String getCodigofonte_linguagem() {
        return codigofonte_linguagem;
    }

    public void setCodigofonte_linguagem(String codigofonte_linguagem) {
        this.codigofonte_linguagem = codigofonte_linguagem;
    }

}
