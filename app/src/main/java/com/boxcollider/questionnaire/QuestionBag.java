package com.boxcollider.questionnaire;

/**
 * Created by aleksander on 3/11/15.
 */

import com.boxcollider.questionnaire.math.AdditionQuestion;
import com.boxcollider.questionnaire.math.MathQuestion;

import java.util.Random;

/**
 * Class that models Test with multiple questions
 */
public class QuestionBag {

    private Question[] bagQuestions;

    public QuestionBag() {

    }

    public static QuestionBag makeAdditionQuestionsBag(int numberOfQuestions) {

        QuestionBag bag = new QuestionBag();
        bag.bagQuestions = new Question[numberOfQuestions];

        Random generator = new Random();


        for (int i = 0; i < bag.bagQuestions.length; i++) {
            Question next = new AdditionQuestion();
            next.make(MathQuestion.Tuple.create(100 + generator.nextInt(100), 100 + generator.nextInt(100)));
            bag.bagQuestions[i] = next;

        }

        return bag;
    }

    public static QuestionBag makeEasy() {
        return new EasyQuestionBag();
    }

    public static QuestionBag makeHard() {
        return new HardQuestionBag();
    }

    @Override
    public String toString() {
        StringBuilder bil=new StringBuilder();
        for (Question q : bagQuestions) {
            bil.append(q.toString());
            bil.append("\n");
        }
        return bil.toString();
    }
}
