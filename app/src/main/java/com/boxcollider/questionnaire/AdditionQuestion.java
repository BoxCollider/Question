package com.boxcollider.questionnaire;

/**
 * Created by aleksander on 3/10/15.
 */
public class AdditionQuestion extends MathQuestion {


    @Override
    public boolean isCorrect(int answer) {
        return (first+second==answer);
    }

}
