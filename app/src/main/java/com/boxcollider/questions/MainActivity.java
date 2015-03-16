package com.boxcollider.questions;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.boxcollider.questionnaire.QuestionBag;
import com.boxcollider.questionnaire.math.MathQuestion;


public class MainActivity extends Activity {
    private MathFragment testUI;
    MathQuestion question;
    private  QuestionBag bag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addUIFragment();

    }

    @Override
    protected void onResume() {
        super.onResume();

        beginNewTest();
        nextQuestion();

        testUI.interactionHandler=new MathFragment.MathClickHandler() {
            @Override
            public void onNextQuestionClicked() {
                nextQuestion();
            }

            @Override
            public void onQuestionAnswerClicked(String answer) {

                int answerAsInt=0;

                try{

                  answerAsInt  = Integer.parseInt(answer);
                }
                catch (NumberFormatException e){
                   //Do not evaluate answer
                }
                checkAnswer(answerAsInt);

            }
        };
    }

    private void checkAnswer(int answer) {

       if (question.isCorrect(answer)){
            testUI.answerCorrect();
       }
        else {
            testUI.answerWrong();
       }

    }

    private void addUIFragment() {
        if(testUI==null){
            testUI = new MathFragment();
            getFragmentManager().beginTransaction().add(R.id.parent, testUI, "MATH").commit();

        }

    }


    private void  beginNewTest(){
        bag = QuestionBag.makeAdditionQuestionsBag(10);
        Log.i("bag",bag.toString());

    }

    private void nextQuestion(){

        if (bag.hasMoreQuestions()){

        question = (MathQuestion) bag.giveNextQuestion();
        testUI.showQuestion(question.getFirst(), question.getSecond());

        }
        else{
            endTest();
        }
    }

    private void endTest(){
        Log.i("test","TEST ENDED");
    }



}
