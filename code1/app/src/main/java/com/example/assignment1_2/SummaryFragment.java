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
    private String[] emotionsNames;
    private Calendar calendar = Calendar.getInstance();
    private static final String ARGS_EMOTION_NAMES_ARRAY = "emotionsNames";
    private static final String ARGS_EMOTION_ARRAY = "emotions";
    public SummaryFragment() {

    }

    public static SummaryFragment newInstance(ArrayList<Emotion> emotions, String[] emotionsNames) {
        SummaryFragment fragment = new SummaryFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARGS_EMOTION_NAMES_ARRAY, emotionsNames);
        args.putSerializable(ARGS_EMOTION_ARRAY, emotions);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String today;

        Bundle args = requireArguments();

        emotionsNames = args.getStringArray(ARGS_EMOTION_NAMES_ARRAY);
        emotions = (ArrayList<Emotion>) requireArguments().getSerializable(ARGS_EMOTION_ARRAY);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        today = year+"-"+month+"-"+day;

        int[] emotionNumbers = new int[6];
        for (int i = 0; i < emotions.size();i++) {
            Emotion emotion = emotions.get(i);
            if (today.equals(emotion.getDay())) {
                if (emotionsNames[0].equals(emotion.getEmotion())) {
                    emotionNumbers[0]++;
                } else if (emotionsNames[1].equals(emotion.getEmotion())) {
                    emotionNumbers[1]++;
                } else if (emotionsNames[2].equals(emotion.getEmotion())) {
                    emotionNumbers[2]++;
                } else if (emotionsNames[3].equals(emotion.getEmotion())) {
                    emotionNumbers[3]++;
                } else if (emotionsNames[4].equals(emotion.getEmotion())) {
                    emotionNumbers[4]++;
                } else if (emotionsNames[5].equals(emotion.getEmotion())) {
                    emotionNumbers[5]++;
                }
            }
        }

        String happyText = emotionsNames[0]+": "+emotionNumbers[0];
        String sadText = emotionsNames[1]+": "+emotionNumbers[1];
        String angryText = emotionsNames[2]+": "+emotionNumbers[2];
        String anxiousText = emotionsNames[3]+": "+emotionNumbers[3];
        String calmText = emotionsNames[4]+": "+emotionNumbers[4];
        String tiredText = emotionsNames[5]+": "+emotionNumbers[5];


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
