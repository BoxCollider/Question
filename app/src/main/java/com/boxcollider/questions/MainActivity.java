package com.boxcollider.questions;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;

import com.boxcollider.questionnaire.Question;
import com.boxcollider.questionnaire.math.SubtractionQuestion;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        getFragmentManager().beginTransaction().add(R.id.parent, new MathFragment(), "MATH").commit();




    }






    private void testSubstraction() {

    }

}
