package com.boxcollider.questionnaire.math;

/**
 * Created by aleksander on 3/10/15.
 */
public class SubstractionQuestion extends MathQuestion {


    @Override
    public boolean isCorrect(int answer) {


        if(firstDigit < secondDigit){
            throw new IllegalArgumentException("Substraction with negative result");
        }
        return (firstDigit - secondDigit == answer);
    }

}
