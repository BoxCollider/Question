package com.boxcollider.questionnaire;

/**
 * Created by aleksander on 3/10/15.
 */
public  interface  Question <T>{
    public Question make(T data);
    public boolean isCorrect(int answer);
}
