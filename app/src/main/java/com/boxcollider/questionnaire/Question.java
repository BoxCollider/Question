package com.boxcollider.questionnaire;

/**
 * Created by aleksander on 3/10/15.
 */

/**
 * Base interface representing a question in a test.
 * <br/>
 * Responsible for creating and checking a question.
 * <br/>
 * Methods are implemented in subclasses
 * <br/>
 *
 * @param <T> Any object that will hold the question contents
 */
public interface Question<T> {

    /**
     * Implementation must supply question contents
     *
     * @param questionContents Arbitrary object
     * @return
     */
    public Question make(T questionContents);

    /**
     * Implementers must perform check on the answer
     *
     * @param answer Answer supplied by the user
     * @return if answer is correct or no
     */
    public boolean isCorrect(int answer);
}
