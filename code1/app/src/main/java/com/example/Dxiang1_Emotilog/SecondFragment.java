package com.example.Dxiang1_Emotilog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.Dxiang1_Emotilog.databinding.FragmentSecondBinding;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    /*Second Fragment holds the actual list log of the
    * users emotions thats about all it does*/
    private FragmentSecondBinding binding;

    private ArrayList<Emotion> emotions;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        //template
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        //uses the custom EmotionArrayAdapter to set up a proper listview
        //to catalog all the emotion inputs from the user
        super.onViewCreated(view, savedInstanceState);

        ListView emotionList = view.findViewById(R.id.emotion_list);
        MainActivity activity = (MainActivity) requireActivity();
        emotions = activity.getEmotions();
        EmotionArrayAdapter arrayAdapter = new EmotionArrayAdapter(requireContext(), emotions);
        emotionList.setAdapter(arrayAdapter);
    }

    @Override
    public void onDestroyView() {
        //template
        super.onDestroyView();
        binding = null;
    }

}