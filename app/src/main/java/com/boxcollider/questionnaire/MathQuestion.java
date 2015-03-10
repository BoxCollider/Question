package com.boxcollider.questionnaire;

import android.util.Pair;

/**
 * Created by aleksander on 3/10/15.
 */
public  class MathQuestion   implements Question<Pair<Integer,Integer>>  {

    int first;
    int second;




    @Override
    public Question make(Pair<Integer, Integer> data) {
        this.first=data.first;
        this.second=data.second;
        return this;
    }

    public boolean isCorrect(int answer) {
        return false;
    }
}
