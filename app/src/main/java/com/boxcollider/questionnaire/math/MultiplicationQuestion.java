package com.boxcollider.questionnaire.math;

/**
 * Created by aleksander on 3/10/15.
 */
public class MultiplicationQuestion extends MathQuestion {


    @Override
    public boolean isCorrect(int answer) {
        return (first * second == answer);
    }

}
