package com.boxcollider.questionnaire.math;

import android.util.Pair;

import com.boxcollider.questionnaire.Question;

/**
 * Created by aleksander on 3/10/15.
 */
public  class MathQuestion   implements Question<Pair<Integer, Integer>> {

    int first;
    int second;




    @Override
    public Question make(Pair<Integer, Integer> questionContents) {
        this.first= questionContents.first;
        this.second= questionContents.second;
        return this;
    }




    public boolean isCorrect(int answer) {
        return false;
    }
}
