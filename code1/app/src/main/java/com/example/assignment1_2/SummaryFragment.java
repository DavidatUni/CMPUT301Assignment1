package com.example.assignment1_2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class SummaryFragment extends DialogFragment {
    private ArrayList<Emotion> emotions;
    private Calendar calendar = Calendar.getInstance();
    public SummaryFragment(ArrayList<Emotion> emotions) {
        this.emotions = emotions;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String today;

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        today = year+"-"+month+"-"+day;

        int[] emotionNumbers = new int[6];
        for (int i = 0; i < emotions.size();i++) {
            Emotion emotion = emotions.get(i);
            if (today.equals(emotion.getDay())) {
                if ("Happy".equals(emotion.getEmotion())) {
                    emotionNumbers[0]++;
                } else if ("Sad".equals(emotion.getEmotion())) {
                    emotionNumbers[1]++;
                } else if ("Angry".equals(emotion.getEmotion())) {
                    emotionNumbers[2]++;
                } else if ("Anxious".equals(emotion.getEmotion())) {
                    emotionNumbers[3]++;
                } else if ("Calm".equals(emotion.getEmotion())) {
                    emotionNumbers[4]++;
                } else if ("Tired".equals(emotion.getEmotion())) {
                    emotionNumbers[5]++;
                }
            }
        }

        String happyText = "Happy: "+emotionNumbers[0];
        String sadText = "Sad: "+emotionNumbers[1];
        String angryText = "Angry: "+emotionNumbers[2];
        String anxiousText = "Anxious: "+emotionNumbers[3];
        String calmText = "Calm: "+emotionNumbers[4];
        String tiredText = "Tired: "+emotionNumbers[5];


        View view = LayoutInflater.from(getContext()).inflate(R.layout.summary_fragment, null);
        TextView happy = view.findViewById(R.id.happy);
        TextView sad = view.findViewById(R.id.sad);
        TextView angry = view.findViewById(R.id.angry);
        TextView anxious = view.findViewById(R.id.anxious);
        TextView calm = view.findViewById(R.id.calm);
        TextView tired = view.findViewById(R.id.tired);
        happy.setText(happyText);
        sad.setText(sadText);
        angry.setText(angryText);
        anxious.setText(anxiousText);
        calm.setText(calmText);
        tired.setText(tiredText);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder
                .setView(view)
                .setTitle("Daily Emotion Summary")
                .setNegativeButton("Close", null)
                .create();
    }
}
