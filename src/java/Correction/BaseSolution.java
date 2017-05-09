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
public class BaseSolution extends Corrector {
    /**
     * compara a saída dos códigos do aluno e do professor 
     * @param attempt caminho para o executável compilado a partir do código do aluno
     * @param answer caminho para o executável compilado a partir do código do professor
     * @param input valor de entrada a ser passado a ambos os executáveis
     * @return true se ambos os códigos retornam o mesmo valor para a entrada dada
     * @throws Exception se ocorrer erro na execução
     */
    @Override
    public boolean correct(String attempt, String answer, String input) throws Exception{
        return super.execute(attempt, input).equals(super.execute(answer, input));
    }
}
