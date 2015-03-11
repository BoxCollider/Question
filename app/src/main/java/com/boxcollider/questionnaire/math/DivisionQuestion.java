package com.boxcollider.questionnaire.math;

/**
 * Created by aleksander on 3/10/15.
 */
public class DivisionQuestion extends MathQuestion {


    @Override
    public boolean isCorrect(int answer) {
        if(secondDigit ==0){
            throw new ArithmeticException("Cannot divide by zero");
        }

        if(firstDigit % secondDigit !=0){
            throw new IllegalArgumentException("Division with remainder");
        }
        return (firstDigit / secondDigit == answer);
    }

}
