package com.boxcollider.questionnaire.math;

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
public abstract class MathQuestion implements Question<MathQuestion.Tuple> {

    public int firstDigit;
    public int secondDigit;

    //Helper class for holding simple data structure for storing question parts
    public static class Tuple{
        int first;
        int second;

        private Tuple(int first, int second){
            this.first=first;
            this.second = second;
        }

        public static Tuple create(int first,int second){
            return new Tuple(first,second);
        }


    }

    @Override
    public Question make(Tuple questionContents) {
        this.firstDigit=questionContents.first;
        this.secondDigit = questionContents.second;
        return this;
    }

}
