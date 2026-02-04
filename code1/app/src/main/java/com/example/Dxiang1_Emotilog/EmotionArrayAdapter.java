package com.example.Dxiang1_Emotilog;

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
    /*The custom arrayadapter for emotions to both display the emotion name
    * and the date it was recorded. uses a simple linear layout xml with 2
    * textviews to achieve this*/
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
