package com.boxcollider.questionnaire.math;

/**
 * Created by aleksander on 3/10/15.
 */
public class DivisionQuestion extends MathQuestion {


    @Override
    public boolean isCorrect(int answer) {
        if(second==0){
            throw new ArithmeticException("Cannot divide by zero");
        }

        if(first%second!=0){
            throw new IllegalArgumentException("Division with remainder");
        }
        return (first / second == answer);
    }

}
