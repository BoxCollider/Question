package com.boxcollider.questions;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.boxcollider.questionnaire.QuestionBag;
import com.boxcollider.questionnaire.math.MathQuestion;


public class MainActivity extends Activity {
    private MathFragment questionUIFragment;
    MathQuestion question;
    private QuestionBag bag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        findOrAddQuestionsUIFragment();
    }

    @Override
    protected void onResume() {

        super.onResume();

        beginNewTest();
        nextQuestion();

        becomeMathFragmentDelegate();


    }

    /**
     * Handles Fragment to Activity back communication.
     * Activity is an observer for the Fragment that delegates responsibility
     */
    private void becomeMathFragmentDelegate() {

        questionUIFragment.interactionHandler = new MathFragment.MathClickHandler() {
            @Override
            public void onNextQuestionClicked() {
                nextQuestion();
            }

            @Override
            public void onQuestionAnswerClicked(String answer) {

                int answerAsInt = 0;

                try {

                    answerAsInt = Integer.parseInt(answer);
                } catch (NumberFormatException e) {
                    //Do not evaluate answer
                }
                checkAnswer(answerAsInt);

            }
        };
    }

    /**
     * Check if answer supplied by the user is correct
     * @param answer
     */
    private void checkAnswer(int answer) {

        if (question.isCorrect(answer)) {
            questionUIFragment.answerCorrect();
        } else {
            questionUIFragment.answerWrong();
        }

    }

    /**
     * Take reference for MathFragment instance if it already exists or create new one
     */
    private void findOrAddQuestionsUIFragment() {

        questionUIFragment = (MathFragment) getFragmentManager().findFragmentByTag("MATH");

        if (questionUIFragment == null) {

            questionUIFragment = new MathFragment();
            getFragmentManager().beginTransaction().add(R.id.parent, questionUIFragment, "MATH").commit();
        }


    }


    /**
     * Creates new test with supplied number of questions
     */
    private void beginNewTest() {
        bag = QuestionBag.makeAdditionQuestionsBag(10);
        Log.i("bag", bag.toString());

    }

    /**
     * Switch to next test question
     */
    private void nextQuestion() {

        if (bag.hasMoreQuestions()) {

            question = (MathQuestion) bag.giveNextQuestion();
            questionUIFragment.showQuestion(question.getFirst(), question.getSecond());

        } else {
            endTest();
        }
    }

    /**
     * End test last question answered
     */
    private void endTest() {
        Log.i("test", "TEST ENDED");
    }


}
