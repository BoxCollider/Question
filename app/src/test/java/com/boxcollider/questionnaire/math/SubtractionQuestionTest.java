package com.boxcollider.questionnaire.math;

import com.boxcollider.questionnaire.Question;

import org.junit.Assert;
import org.junit.Test;

public class SubtractionQuestionTest {

    @Test
    public void testIsCorrect() throws Exception {

        Question q = new SubtractionQuestion();
        q.make(MathQuestion.Tuple.create(60,35));
        Assert.assertTrue(q.isCorrect(25));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeResult() throws Exception {

        Question q = new SubtractionQuestion();
        q.make(MathQuestion.Tuple.create(60,80));
        q.isCorrect(25);
    }
}