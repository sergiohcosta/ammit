/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compilador;

import Correction.BaseSolution;
import Correction.Corrector;
import DAO.CasotesteDAO;
import beans.Casoteste;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class Compilador {

    private static String TCC = "";

    public static CodigoCompilado compilar(String path) {
        
        Properties prop = new Properties();
        InputStream input = null;
        
        try {
            input = Compilador.class.getClassLoader().getResourceAsStream("ammit.properties");
            prop.load(input);

            TCC = prop.getProperty("tcc");
            
        } catch (IOException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }

        CodigoCompilado c = new CodigoCompilado();
        String exec = path.replaceFirst("\\.c", ".exe");
        Runtime r = Runtime.getRuntime();
        try {
            String executar = TCC + "\"" + exec + "\" \"" + path + "\"";
            Process p = r.exec(executar);
            if (p.waitFor(5, TimeUnit.SECONDS)) {
                if (p.exitValue() == 0) {
                    c.setSucesso(true);
                    c.setExec(exec);
                } else {
                    c.setSucesso(false);
                    BufferedReader error = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String x = error.readLine(), response = "";
                    while (x != null) {
                        response += x;
                        x = error.readLine();
                        if (x != null) {
                            response += "\r\n";
                        }
                    }
                    c.setErros(response);
                }
            } else {
                c.setSucesso(false);
                c.setErros("Tempo-limite para compilação excedido");
            }
        } catch (IOException io) {
            c.setSucesso(false);
            c.setErros(io.getMessage());
        } catch (InterruptedException ex) {
            c.setSucesso(false);
            c.setErros(ex.getMessage());
        }
        return c;
    }

    /*
    private static void printLines(String name, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(name + " " + line);
        }
    }

    private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor(1, TimeUnit.SECONDS);
        System.out.println(command + " exitValue() " + pro.exitValue());
    }

    public static void main(String[] args) {
        //Process process = new ProcessBuilder("C:\\PathToExe\\MyExe.exe", "param1", "param2").start();
        try {

            CasotesteDAO ctDao = new CasotesteDAO();
            Casoteste ct = new Casoteste();
            ct = ctDao.obtemCasoteste(14);
            
            String lines[] = ct.getEntrada().split("\\r?\\n");

            //InputStream initialStream = new FileInputStream(new File("source.txt"));
            InputStream initialStream = ct.getCodigofonte();
            byte[] buffer = new byte[initialStream.available()];
            initialStream.read(buffer);

            File targetFile = new File("targetFile.c");
            OutputStream outStream = new FileOutputStream(targetFile);
            outStream.write(buffer);
            
            // fazer isso vai gerar um executavel na raiz do projeto
            runProcess("tcc/tcc.exe targetFile.c");
            
            Corrector corr = new BaseSolution();
            for(String line : lines) {
                System.out.println(corr.execute("targetFile.exe", line));
            }
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
