package com.boxcollider.questionnaire.math;

/**
 * Created by aleksander on 3/10/15.
 */
public class SubstractionQuestion extends MathQuestion {


    @Override
    public boolean isCorrect(int answer) {


        if(first<second){
            throw new IllegalArgumentException("Substraction with negative result");
        }
        return (first - second == answer);
    }

}
