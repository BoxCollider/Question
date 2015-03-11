package com.boxcollider.questionnaire.math;

import org.junit.Assert;
import org.junit.Test;

public class AdditionQuestionTest {

    @Test
    public void testIsCorrect() throws Exception {

        AdditionQuestion q = new AdditionQuestion();
        q.make(MathQuestion.Tuple.create(5,6));

        Assert.assertTrue(q.isCorrect(11));
        Assert.assertFalse(q.isCorrect(60));
    }
}