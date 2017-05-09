/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correction;

/**
 *
 * @author Renam
 */
public class ResponseAnalyser extends Corrector{
    /**
     * submete a resposta do aluno ao código avaliador do professor
     * @param attempt caminho para o executável compilado a partir do código do aluno
     * @param answer caminho para o executável compilado a partir do código do professor
     * @param input valor de entrada a ser passado ao código do aluno e, posteriormente, ao código do professor juntop com a saída do código do aluno
     * @return true se o código do professor retornar 0
     * @throws Exception se ocorrer erro na execução
     */
    @Override
    public boolean correct(String attempt, String answer, String input) throws Exception{
        return super.execute(answer, input + " " + super.execute(attempt, input)).equals("0");
    }
}
