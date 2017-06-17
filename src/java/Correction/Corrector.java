/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *
 * @author Renam
 */
public abstract class Corrector {
    /**
     * classe abstrata pra definir o modo como a resposta certa é dada
     * @param attempt definido na especialização
     * @param answer definido na especialização
     * @param input definido na especialização
     * @return definido na especialização
     * @throws Exception definido na especialização
     */
    abstract boolean correct(String attempt, String answer, String input) throws Exception;
    
    /**
     * executa o programa com os parâmetros dados
     * @param exec caminho para o executável
     * @param input dados a serem inseridos na entrada-padrão do programa
     * @return a primeira linha do retorno do programa (ainda não assumimos resposta em multi-linhas)
     * @throws Exception caso ocorra algum erro de runtime
     */
    public String execute(String exec, String input) throws Exception{
        Runtime rt = Runtime.getRuntime();
        Process pro = rt.exec(exec);
        OutputStream os = pro.getOutputStream();
        BufferedReader is = new BufferedReader(new InputStreamReader(pro.getInputStream()));
        input+="\n";
        os.write(input.getBytes());
        os.flush();
        pro.waitFor();
        String x=is.readLine(), response="";
        while (x != null){
            response+=x;
            x=is.readLine();
            if (x!= null) response+="\r\n";
        }
        return response;
    }
}
