package com.boxcollider.questionnaire.math;

/**
 * Created by aleksander on 3/10/15.
 */

public final class AdditionQuestion extends MathQuestion {

    @Override
    public Integer getAnswer() {
        return firstDigit + secondDigit;
    }

}
