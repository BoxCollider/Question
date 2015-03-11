package com.boxcollider.questionnaire.math;

import com.boxcollider.questionnaire.Question;

import junit.framework.Assert;

import org.junit.Test;

public class MultiplicationQuestionTest {

    @Test
    public void testIsCorrect() throws Exception {
        Question q = new MultiplicationQuestion();
        q.make(MathQuestion.Tuple.create(5,6));
        Assert.assertTrue(q.isCorrect(30));
        Assert.assertFalse(q.isCorrect(50));

    }
}