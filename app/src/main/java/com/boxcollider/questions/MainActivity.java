package com.boxcollider.questions;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;

import com.boxcollider.questionnaire.math.AdditionQuestion;
import com.boxcollider.questionnaire.math.DivisionQuestion;
import com.boxcollider.questionnaire.math.MultiplicationQuestion;
import com.boxcollider.questionnaire.Question;
import com.boxcollider.questionnaire.math.SubstractionQuestion;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        getFragmentManager().beginTransaction().add(R.id.parent, new MathFragment(), "MATH").commit();


        testAddition();
        testMultiplication();
        testDivision();
        testSubstraction();

    }

// Test methods

    private void testAddition() {
        Question q = new AdditionQuestion();
        q.make(new Pair<>(5,6));
        boolean correct = q.isCorrect(11);
        Log.i("answer addition", String.valueOf(correct));
    }

    private void testMultiplication() {
        Question q = new MultiplicationQuestion();
        q.make(new Pair<>(5,6));
        boolean correct = q.isCorrect(30);
        Log.i("answer multiplication", String.valueOf(correct));
    }

    private void testDivision() {

        Question q = new DivisionQuestion();
        q.make(new Pair<>(30,5));
        boolean correct = q.isCorrect(6);
        Log.i("answer division", String.valueOf(correct));

    }

    private void testSubstraction() {
        Question q = new SubstractionQuestion();
        q.make(new Pair<>(30,5));
        boolean correct = q.isCorrect(25);
        Log.i("answer substraction", String.valueOf(correct));
    }

}
