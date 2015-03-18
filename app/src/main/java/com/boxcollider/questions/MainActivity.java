package com.boxcollider.questions;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;

import com.boxcollider.questionnaire.QuestionBag;
import com.boxcollider.questionnaire.math.MathQuestion;
import com.boxcollider.questionnaire.serializers.AdditionQuestionBag;
//TODO add other types of math tests
//TODO what happens when we solve last question ?
//TODO add sounds
//TODO add button dimensions for landscape and tablets
//TODO add Leaderboards and achievements
//TODO implement screen for 4 question types
//TODO refactor end test dialog


public class MainActivity extends Activity {

    private final String TAG = "bag";
    private MathFragment questionUIFragment;
    MathQuestion question;
    private QuestionBag bag;
    private static final int TEST_QUESTIONS_NUMBER = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findOrAddQuestionsUIFragment(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String savedAdditionTest = PreferenceManager.getDefaultSharedPreferences(this).getString("ADD", "");

        //create new test
        if (savedAdditionTest.equals("")) {
            beginNewTest();

        }
        //or load last saved test
        else {
            loadSavedTest(savedAdditionTest);
        }

        nextQuestion();
        becomeMathFragmentDelegate();
        questionUIFragment.setMaxProgress(TEST_QUESTIONS_NUMBER);

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
     *
     * @param answer
     */
    private void checkAnswer(int answer) {

        if (question.isCorrect(answer)) {
            questionUIFragment.answerCorrect();
            if(bag.hasMoreQuestions()==false){
                showEndTestDialog();
            }
        } else {
            questionUIFragment.answerWrong();
        }

    }

    /**
     * Take reference for MathFragment instance if it already exists or create new one
     *
     * @param savedInstanceState
     */
    private void findOrAddQuestionsUIFragment(Bundle savedInstanceState) {

        questionUIFragment = (MathFragment) getFragmentManager().findFragmentByTag("MATH");

        if (savedInstanceState == null) {

            questionUIFragment = new MathFragment();
            getFragmentManager().beginTransaction().add(R.id.parent, questionUIFragment, "MATH").commit();
        }


    }


    /**
     * Creates new test with supplied number of questions
     */
    private void beginNewTest() {
        bag = QuestionBag.makeAdditionQuestionsBag(TEST_QUESTIONS_NUMBER);
        Log.i(TAG, "NEW TEST CREATED");
        Log.i(TAG, bag.toString());

    }

    /**
     * Load auto saved test in progress
     *
     * @param savedAdditionTest
     */
    private void loadSavedTest(String savedAdditionTest) {
        AdditionQuestionBag qbag = AdditionQuestionBag.fromGSONString(savedAdditionTest);
        bag = AdditionQuestionBag.toQuestionBag(qbag);
        //return one step because we are loading auto next question
        bag.setCurrentQuestionIndex(bag.getCurrentQuestionIndex() - 1);
        Log.i(TAG, "OLD TEST LOADED");
        Log.i(TAG, bag.toString());
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

    /**
     * Save test state
     */
    private void saveTest() {
        AdditionQuestionBag adBag = AdditionQuestionBag.fromQuestionBag(bag);
        String gson = AdditionQuestionBag.toGSONString(adBag);
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("ADD", gson).commit();
        Log.i(TAG, "TEST SAVED");
    }

    /**
     * End test last question answered
     */
    private void endTest() {
        Log.i(TAG, "TEST ENDED");

    }

    private void showEndTestDialog() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                new TestCompletedDialogFragment().show(getFragmentManager(), "HIHIHI");
            }
        }, 1200);
    }


}
