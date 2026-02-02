package com.example.assignment1_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EmotionArrayAdapter extends ArrayAdapter<Emotion> {
    public EmotionArrayAdapter(Context context, ArrayList<Emotion> emotions) {
        super(context, 0, emotions);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_content, parent, false);
        } else {
            view = convertView;
        }

        Emotion emotion = getItem(position);
        TextView emotionName = view.findViewById(R.id.emotion_name);
        TextView dateTime = view.findViewById(R.id.date_time);
        emotionName.setText(emotion.getEmotion());
        dateTime.setText(emotion.getDay().toString());
        return view;
    }
}
