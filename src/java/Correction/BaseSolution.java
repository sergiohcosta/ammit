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
    @Override
    public boolean correct(String attempt, String answer, String input) throws Exception{
        return super.execute(attempt, input).equals(super.execute(answer, input));
    }
}
