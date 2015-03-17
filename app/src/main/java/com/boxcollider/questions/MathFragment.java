package com.boxcollider.questions;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MathFragment extends Fragment {

    public interface MathClickHandler {

        public void onNextQuestionClicked();

        public void onQuestionAnswerClicked(String answer);
    }

    public MathClickHandler interactionHandler;

    private TextView firstDigit;
    private TextView secondDigit;
    private EditText answer;
    private ProgressBar uiProgress;
    private int answerInitialTextColor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_math, container, false);

        firstDigit = (TextView) v.findViewById(R.id.first_digit);
        secondDigit = (TextView) v.findViewById(R.id.second_digit);
        uiProgress= (ProgressBar) v.findViewById(R.id.uiProgress);
        uiProgress.getProgressDrawable().setColorFilter(getResources().getColor(R.color.yellowBright), PorterDuff.Mode.SRC_IN);
        answer = (EditText) v.findViewById(R.id.answer);
        answer.getBackground().setColorFilter(getResources().getColor(R.color.lilacBright), PorterDuff.Mode.SRC_IN);
        answer.setOnTouchListener(lit);
        answerInitialTextColor= getResources().getColor(R.color.yellowBright);
        answer.setTextColor(answerInitialTextColor);
        v.findViewById(R.id.nextQuestion).setOnClickListener(nextQuestionClick);
        v.findViewById(R.id.answerQuestion).setOnClickListener(answerQuestionClick);


        return v;
    }

    private void resetTextColor() {

    }

    /**
     * Edit text must reset previous coloring from answer check ew answer is supplied by the user.
     */
   EditText.OnTouchListener lit = new EditText.OnTouchListener() {
       @Override
       public boolean onTouch(View view, MotionEvent motionEvent) {
           if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
               //if(answer.getCurrentTextColor()!=answerInitialTextColor){
               answer.setText("");
               answer.setTextColor(answerInitialTextColor);
               //}
           }
           return false;
       }
   };



    /**
     * User goes to next question
     * We must reset text color for the answer to initial state
     * Delegate responsibility to other Class implementing MathClickHandler Interface
     */
    View.OnClickListener nextQuestionClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            answer.setTextColor(answerInitialTextColor);


            if(interactionHandler==null){
                Log.i("questions","Next Question No Click Handler");
                return;
            }
            interactionHandler.onNextQuestionClicked();
        }
    };

    /**
     * Answer evaluation.
     * Delegate responsibility to other Class implementing MathClickHandler Interface
     */
    View.OnClickListener answerQuestionClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(interactionHandler==null){
                Log.i("questions","Answer Question No Click Handler");
                return;
            }
            interactionHandler.onQuestionAnswerClicked(answer.getText().toString());
        }
    };

    public void showQuestion(int firstDigit, int secondDigit) {
        clear();
        this.firstDigit.setText(String.valueOf(firstDigit));
        this.secondDigit.setText(String.valueOf(secondDigit));



    }

    public void showProgress(int progress){
        uiProgress.setProgress(progress);
    }

    public void setMaxProgress(int progress){
        uiProgress.setMax(progress);
    }


    /**
     * Make visual indication on correct answer
     */
    public void answerCorrect(){
        answer.setTextColor(Color.GREEN);
        answer.animate().yBy(-100).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() {
            @Override
            public void run() {

                answer.animate().setInterpolator(new BounceInterpolator()).yBy(100);
            }
        }).start();
    }

    /**
     * Make visual indication on wrong answer
     */
    public void answerWrong(){
        answer.setTextColor(Color.RED);
        answer.animate().xBy(-300).yBy(300).rotationBy(-90).withEndAction(new Runnable() {
            @Override
            public void run() {

                answer.animate().xBy(300).yBy(-300).rotationBy(90).setInterpolator(new AccelerateInterpolator()).start();
            }
        }).start();
    }

    private void clear() {

        firstDigit.setText("");
        secondDigit.setText("");
        answer.setText("");
    }


}
