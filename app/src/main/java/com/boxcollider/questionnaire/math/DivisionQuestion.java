package com.boxcollider.questionnaire.math;

/**
 * Created by aleksander on 3/10/15.
 */
public final class DivisionQuestion extends MathQuestion {

    /**
     * Perform check on the answer
     * @param answer Answer supplied by the user
     * @return if answer is correct or no
     * @throws java.lang.ArithmeticException if divisor equals 0
     * @throws java.lang.IllegalArgumentException when division has remainder
     */
    @Override
    public boolean isCorrect(int answer) {
        //Division by zero not permitted
        if (secondDigit == 0) {
            throw new ArithmeticException("Division by zero");
        }

        //Division remainder not allowed
        if (firstDigit % secondDigit != 0) {
            throw new IllegalArgumentException("Division has remainder.");
        }

        return (firstDigit / secondDigit == answer);
    }

}
