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
    //classe abstrata pra definir o modo como a resposta certa é dada
    abstract boolean correct(String attempt, String answer, String input) throws Exception;
    
    //executa o arquivo em exec, jogando input como entrada
    //retorna o valor retornado pelo programa
    public String execute(String exec, String input) throws Exception{
        Runtime rt = Runtime.getRuntime();
        Process pro = rt.exec(exec);
        OutputStream os = pro.getOutputStream();
        BufferedReader is = new BufferedReader(new InputStreamReader(pro.getInputStream()));
        input+="\n";
        os.write(input.getBytes());
        os.flush();
        pro.waitFor();
        return is.readLine();
    }
}
