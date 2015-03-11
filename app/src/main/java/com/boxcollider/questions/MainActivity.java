package com.boxcollider.questions;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addUIFragment();
    }

    private void addUIFragment() {
        getFragmentManager().beginTransaction().add(R.id.parent, new MathFragment(), "MATH").commit();
    }

}
