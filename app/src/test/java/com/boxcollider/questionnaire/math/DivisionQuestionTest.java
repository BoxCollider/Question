package com.boxcollider.questionnaire.math;

import com.boxcollider.questionnaire.Question;

import org.junit.Assert;
import org.junit.Test;

public class DivisionQuestionTest {


    @Test
    public void testIsCorrect() throws Exception {

        Question q = new DivisionQuestion();
        q.make(MathQuestion.Tuple.create(30, 5));

        Assert.assertTrue(q.isCorrect(6));
        Assert.assertFalse(q.isCorrect(3));

    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() throws Exception {

        Question q = new DivisionQuestion();
        q.make(MathQuestion.Tuple.create(30, 0));
        q.isCorrect(9);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoRemainder() throws Exception {

        Question q = new DivisionQuestion();
        q.make(MathQuestion.Tuple.create(30, 7));
        q.isCorrect(9);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstDigitGreaterThanSecondDigit() throws Exception {

        Question q = new DivisionQuestion();
        q.make(MathQuestion.Tuple.create(50,70));
        q.isCorrect(9);

    }
}