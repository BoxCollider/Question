package com.boxcollider.questionnaire.serializers;

import com.boxcollider.questionnaire.QuestionBag;
import com.boxcollider.questionnaire.math.AdditionQuestion;
import com.google.gson.Gson;

/**
 * Created by aleksander on 3/16/15.
 */
public class AdditionQuestionBag {

    public AdditionQuestionBag() {
    }

    public static AdditionQuestionBag fromQuestionBag(QuestionBag bag){
          AdditionQuestionBag adBag = new AdditionQuestionBag();
          adBag.questions= (AdditionQuestion[]) bag.getQuestions();
          adBag.currentQuestionIndex=bag.getCurrentQuestionIndex();
          return adBag;

    }

    public static QuestionBag toQuestionBag(AdditionQuestionBag adBag){
        QuestionBag bag = new QuestionBag();
        bag.setQuestions(adBag.questions);
        bag.setCurrentQuestionIndex(adBag.currentQuestionIndex);
        return bag;
    }

    public static String toGSONString(AdditionQuestionBag bag){
        Gson gson = new Gson();
        String result= gson.toJson(bag);
        return result;
    }

    public static AdditionQuestionBag fromGSONString(String gsonString){
        Gson gson = new Gson();
        AdditionQuestionBag adBag  = gson.fromJson(gsonString,AdditionQuestionBag.class);
        return adBag;

    }


    public AdditionQuestion[] questions;
    public int currentQuestionIndex;
}
