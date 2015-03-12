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
 * @param <Q> Any object that will hold the question contents
 * @param <A> Any object that will hold the question answer
 */
public interface Question<Q,A> {

    /**
     * Implementation must supply question contents
     *
     * @param questionContents Arbitrary object
     * @return
     */
    public Question make(Q questionContents);

    /**
     * Implementers must perform check on the answer
     *
     * @param answer Answer supplied by the user
     * @return if answer is correct or no
     */
    public boolean isCorrect(int answer);

    public A getAnswer();

}
