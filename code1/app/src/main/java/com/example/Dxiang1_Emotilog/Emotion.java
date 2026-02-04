package com.example.Dxiang1_Emotilog;

import java.io.Serializable;
import java.util.Calendar;

public class Emotion implements Serializable {
    /*Emotion object class holds 2 main variables, what emotion
    it holds and what day it was recorded. A calender is used
    * to get proper time notation. Has getters at the bottom*/
    private String emotion;
    private String current;

    public Emotion(String emotion){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        current = year+"-"+month+"-"+day;
        this.emotion = emotion;
    }

    public String getEmotion() {
        return emotion;
    }

    public String getDay() {
        return current;
    }
}
