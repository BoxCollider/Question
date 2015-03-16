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
public abstract class MathQuestion implements Question<MathQuestion.Tuple, Integer> {

    protected int firstDigit;
    protected int secondDigit;


    //Helper class for holding simple data structure for storing question parts
    public static class Tuple {
        private final int first;
        private final int second;

        private Tuple(int first, int second) {
            this.first = first;
            this.second = second;
        }

        /**
         * Static factory method
         *
         * @param first  first element of the question
         * @param second second element of the question
         * @return
         */
        public static Tuple create(int first, int second) {
            return new Tuple(first, second);
        }

    }

    /**
     * @param questionContents Arbitrary object
     * @return ready to use question instance
     */
    @Override
    public Question make(Tuple questionContents) {

        this.firstDigit = questionContents.first;
        this.secondDigit = questionContents.second;
        return this;
    }

    /**
     * @param answer Answer supplied by the user
     * @return if answer is correct or no
     */
    @Override
    public boolean isCorrect(int answer) {

        return (getAnswer() == answer);
    }

    @Override
    public String toString() {

        return "First: " + firstDigit + ", Second: " + secondDigit;
    }

    public int getFirst(){
        return firstDigit;
    }

    public int getSecond(){
        return secondDigit;
    }
}
