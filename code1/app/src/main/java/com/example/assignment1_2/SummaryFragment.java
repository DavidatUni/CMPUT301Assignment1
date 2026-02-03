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
    /*This is the fragment for showing the user their total daily emotion
    * frequencies. Just tabulates them all up for today*/
    private ArrayList<Emotion> emotions;
    private String[] emotionsNames;

    private static final String ARGS_EMOTION_NAMES_ARRAY = "emotionsNames";
    private static final String ARGS_EMOTION_ARRAY = "emotions";
    public SummaryFragment() {

    }

    public static SummaryFragment newInstance(ArrayList<Emotion> emotions, String[] emotionsNames) {
        /*Stable import of both name and emotion arrays to avoid null errors*/
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
        /*In here all the emotions in the emotions array are looked through
        * it finds one which are from today and them tabulates them to show
        * in the dialog fragment*/

        String today;
        Calendar calendar = Calendar.getInstance();
        //proper import
        Bundle args = requireArguments();
        emotionsNames = args.getStringArray(ARGS_EMOTION_NAMES_ARRAY);
        emotions = (ArrayList<Emotion>) requireArguments().getSerializable(ARGS_EMOTION_ARRAY);

        //filtering out everything except for todays emotions
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

        //setting up Strings for setText to use
        String happyText = emotionsNames[0]+": "+emotionNumbers[0];
        String sadText = emotionsNames[1]+": "+emotionNumbers[1];
        String angryText = emotionsNames[2]+": "+emotionNumbers[2];
        String anxiousText = emotionsNames[3]+": "+emotionNumbers[3];
        String calmText = emotionsNames[4]+": "+emotionNumbers[4];
        String tiredText = emotionsNames[5]+": "+emotionNumbers[5];

        //lots of textViews are grabbed and then set to the total daily number
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
