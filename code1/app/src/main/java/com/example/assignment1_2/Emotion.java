package com.example.assignment1_2;

import android.os.Build;

import java.time.LocalDate;
import java.util.Calendar;


public class Emotion {
    private String emotion;
    private String current;
    private Calendar calendar = Calendar.getInstance();
    public Emotion(String emotion){

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
