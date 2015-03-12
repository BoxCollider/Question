package com.boxcollider.questionnaire.math;

import com.boxcollider.questionnaire.Question;

/**
 * Created by aleksander on 3/10/15.
 */
public final class DivisionQuestion extends MathQuestion {

    /**
     * @param questionContents Arbitrary object
     * @return ready to use question instance
     * @throws java.lang.ArithmeticException      if divisor equals 0
     * @throws java.lang.IllegalArgumentException when division has remainder
     */
    @Override
    public Question make(Tuple questionContents) {
        super.make(questionContents);
        //Division by zero not permitted
        if (secondDigit == 0) {
            throw new ArithmeticException("Division by zero");
        }

        //Division remainder not allowed or first digit less than second
        if (firstDigit % secondDigit != 0) {
            throw new IllegalArgumentException("Division has remainder.");
        }


        return this;
    }

    @Override
    public Integer getAnswer() {

        return firstDigit / secondDigit;
    }

}
