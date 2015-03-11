package com.boxcollider.questionnaire.math;

/**
 * Created by aleksander on 3/10/15.
 */
public final class MultiplicationQuestion extends MathQuestion {

    /**
     * Perform check on the answer
     * @param answer Answer supplied by the user
     * @return if answer is correct or no
     */
    @Override
    public boolean isCorrect(int answer) {
        return (firstDigit * secondDigit == answer);
    }

}
