/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compilador;

/**
 *
 * @author Renam
 */
public class CodigoCompilado {
    private String erros;
    private String exec;
    private boolean sucesso;
    
    /**
     * @return the erros
     */
    public String getErros() {
        return erros;
    }

    /**
     * @param erros the erros to set
     */
    public void setErros(String erros) {
        this.erros = erros;
    }

    

    /**
     * @return the exec
     */
    public String getExec() {
        return exec;
    }

    /**
     * @param exec the exec to set
     */
    public void setExec(String exec) {
        this.exec = exec;
    }

    /**
     * @return the sucesso
     */
    public boolean isSucesso() {
        return sucesso;
    }

    /**
     * @param sucesso the sucesso to set
     */
    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }
    
    
}
