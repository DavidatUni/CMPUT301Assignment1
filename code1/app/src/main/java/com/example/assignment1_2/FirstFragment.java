package com.example.assignment1_2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.assignment1_2.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment implements EditButtonFragment.EditButtonDialogListener {

    private FragmentFirstBinding binding;
    private ArrayList<Emotion> emotions;
    private String[] emotionsNames;

    @Override
    public void editButton(String[] emotionsNames) {
        Button happy = getView().findViewById(R.id.happy_button);
        Button sad = getView().findViewById(R.id.sad_button);
        Button angry = getView().findViewById(R.id.angry_button);
        Button anxious = getView().findViewById(R.id.anxious_button);
        Button calm = getView().findViewById(R.id.calm_button);
        Button tired = getView().findViewById(R.id.tired_button);

        happy.setText(emotionsNames[0]);
        sad.setText(emotionsNames[1]);
        angry.setText(emotionsNames[2]);
        anxious.setText(emotionsNames[3]);
        calm.setText(emotionsNames[4]);
        tired.setText(emotionsNames[5]);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivity activity = (MainActivity) requireActivity();
        emotions = activity.getEmotions();
        emotionsNames = activity.getEmotionsNames();
        editButton(emotionsNames);
        //Log.d("DEBUG", "emotionNames is null? " + (emotionsNames == null));
        binding.logButton.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );
        view.findViewById(R.id.customize_button).setOnClickListener(v ->
                new EditButtonFragment().newInstance(emotionsNames).show(getChildFragmentManager(), "Customize")
        );
        view.findViewById(R.id.happy_button).setOnClickListener(v ->
            emotions.add(new Emotion(emotionsNames[0]))
        );
        view.findViewById(R.id.sad_button).setOnClickListener(v ->
                emotions.add(new Emotion(emotionsNames[1]))
        );
        view.findViewById(R.id.angry_button).setOnClickListener(v ->
                emotions.add(new Emotion(emotionsNames[2]))
        );
        view.findViewById(R.id.calm_button).setOnClickListener(v ->
                emotions.add(new Emotion(emotionsNames[4]))
        );
        view.findViewById(R.id.anxious_button).setOnClickListener(v ->
                emotions.add(new Emotion(emotionsNames[3]))
        );
        view.findViewById(R.id.tired_button).setOnClickListener(v ->
                emotions.add(new Emotion(emotionsNames[5]))
        );

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public ArrayList<Emotion> getDataList() {
        return emotions;
    }
}