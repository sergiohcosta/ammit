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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author sergio
 */
public class comp {

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
    }
}
