package com.boxcollider.questionnaire.serializers;

import com.boxcollider.questionnaire.QuestionBag;

import org.junit.Assert;
import org.junit.Test;

public class AdditionQuestionBagTest {

    @Test
    public void testFromQuestionBag() throws Exception {
        QuestionBag bag= QuestionBag.makeAdditionQuestionsBag(10);
        AdditionQuestionBag adBag = AdditionQuestionBag.fromQuestionBag(bag);
        Assert.assertTrue(adBag.questions.length==10);

    }

    @Test
    public void testToGSONString() throws  Exception {
        QuestionBag bag= QuestionBag.makeAdditionQuestionsBag(10);
        AdditionQuestionBag adBag = AdditionQuestionBag.fromQuestionBag(bag);
        String jsonStringSerialized = AdditionQuestionBag.toGSONString(adBag);
        Assert.assertNotNull(jsonStringSerialized);
        System.out.println(jsonStringSerialized);

    }

}