package com.boxcollider.questionnaire.math;

import android.util.Pair;

import com.boxcollider.questionnaire.Question;

/**
 * Created by aleksander on 3/10/15.
 */

/**
 * Base class for basic math questions.
 * <br/>
 * Encapsulates creation of a math question
 * Subclasses must implement {@link #isCorrect(int answer)} to check
 * <br/>
 * if supplied answer is correct.
 */
public abstract class MathQuestion implements Question<Pair<Integer, Integer>> {

    protected int firstDigit;
    protected int secondDigit;

    @Override
    public Question make(Pair<Integer, Integer> questionContents) {
        this.firstDigit = questionContents.first;
        this.secondDigit = questionContents.second;
        return this;
    }

}
