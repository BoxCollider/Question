package com.boxcollider.questionnaire.math;

/**
 * Created by aleksander on 3/10/15.
 */

/**
 * Concrete implementation of Subtraction question
 */
public final class SubtractionQuestion extends MathQuestion {

    /**
     *
     * @param answer Answer supplied by the user
     * @return if answer is correct or no
     * @throws java.lang.IllegalArgumentException when difference is negative value
     */
    @Override
    public boolean isCorrect(int answer) {

        //Result for subtraction must be positive value
        if(firstDigit < secondDigit){
            throw new IllegalArgumentException("Subtraction with negative result.");
        }
        return (firstDigit - secondDigit == answer);
    }

}
