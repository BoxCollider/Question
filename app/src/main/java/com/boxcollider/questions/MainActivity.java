package com.boxcollider.questions;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.boxcollider.questionnaire.QuestionBag;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addUIFragment();
        QuestionBag bag = QuestionBag.makeAdditionQuestionsBag(10);
        Log.i("bag",bag.toString());

    }

    private void addUIFragment() {
        getFragmentManager().beginTransaction().add(R.id.parent, new MathFragment(), "MATH").commit();
    }

}
