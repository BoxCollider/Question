package com.boxcollider.questionnaire;

/**
 * Created by aleksander on 3/10/15.
 */
public class MultiplicationQuestion extends MathQuestion {


    @Override
    public boolean isCorrect(int answer) {
        return (first * second == answer);
    }

}
