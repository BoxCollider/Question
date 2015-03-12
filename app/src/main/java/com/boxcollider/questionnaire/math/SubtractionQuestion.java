package com.boxcollider.questionnaire.math;

/**
 * Created by aleksander on 3/10/15.
 */

import com.boxcollider.questionnaire.Question;

/**
 * Concrete implementation of Subtraction question
 */
public final class SubtractionQuestion extends MathQuestion {

    /**
     * @param questionContents
     * @return ready to use question instance
     * @throws java.lang.IllegalArgumentException when difference is negative value
     */
    @Override
    public Question make(Tuple questionContents) {

        super.make(questionContents);
        //Result for subtraction must be positive value
        if (firstDigit < secondDigit) {
            throw new IllegalArgumentException("Subtraction with negative result.");
        }

        return this;
    }

    @Override
    public Integer getAnswer() {
        return firstDigit - secondDigit;
    }
}
