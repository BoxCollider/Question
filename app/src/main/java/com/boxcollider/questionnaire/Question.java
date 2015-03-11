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
     * Implementors must perform check on the answer
     *
     * @param answer answer supplied by the user
     * @return
     */
    public boolean isCorrect(int answer);
}
