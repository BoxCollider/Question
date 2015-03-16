package com.boxcollider.questions;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import com.boxcollider.questionnaire.QuestionBag;
import com.boxcollider.questionnaire.math.MathQuestion;
import com.boxcollider.questionnaire.serializers.AdditionQuestionBag;
//TODO keep progress for questions
//TODO implement screen for 4 question types


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


       //load test or create new
       String savedAdditionTest = PreferenceManager.getDefaultSharedPreferences(this).getString("ADD","");

        //create new test
        if(savedAdditionTest.equals("")){
            beginNewTest();

        }
        //load last saved test
        else {
            loadSavedTest(savedAdditionTest);
        }



        nextQuestion();
        becomeMathFragmentDelegate();

      questionUIFragment.setMaxProgress(10);
    }



    @Override
    protected void onPause() {
        super.onPause();

        saveTest();
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
        Log.i("bag", "NEW TEST CREATED");
        Log.i("bag", bag.toString());

    }

    /**
     * Load auto saved test in progress
     * @param savedAdditionTest
     */
    private void loadSavedTest(String savedAdditionTest) {
        AdditionQuestionBag qbag= AdditionQuestionBag.fromGSONString(savedAdditionTest);
        bag= AdditionQuestionBag.toQuestionBag(qbag);
        //return one step because we are loading auto next question
        bag.setCurrentQuestionIndex(bag.getCurrentQuestionIndex()-1);
        Log.i("bag", "OLD TEST LOADED");
        Log.i("bag", bag.toString());
    }

    /**
     * Switch to next test question
     */
    private void nextQuestion() {

        if (bag.hasMoreQuestions()) {

            question = (MathQuestion) bag.giveNextQuestion();
            questionUIFragment.showQuestion(question.getFirst(), question.getSecond());
            questionUIFragment.showProgress(bag.getCurrentQuestionIndex());
        } else {
            endTest();
            questionUIFragment.showProgress(bag.getQuestions().length);
        }
    }

    private void saveTest(){
        AdditionQuestionBag adBag=AdditionQuestionBag.fromQuestionBag(bag);
        String gson= AdditionQuestionBag.toGSONString(adBag);
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("ADD",gson).commit();
        Log.i("bag", "TEST SAVED");
    }

    /**
     * End test last question answered
     */
    private void endTest() {
        Log.i("bag", "TEST ENDED");
    }


}
