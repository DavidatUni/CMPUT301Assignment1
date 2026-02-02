package com.example.assignment1_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.assignment1_2.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ArrayList<Emotion> emotions;

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
        binding.logButton.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );
        view.findViewById(R.id.happy_button).setOnClickListener(v ->
            emotions.add(new Emotion("Happy"))
        );
        view.findViewById(R.id.sad_button).setOnClickListener(v ->
                emotions.add(new Emotion("Sad"))
        );
        view.findViewById(R.id.angry_button).setOnClickListener(v ->
                emotions.add(new Emotion("Angry"))
        );
        view.findViewById(R.id.calm_button).setOnClickListener(v ->
                emotions.add(new Emotion("Calm"))
        );
        view.findViewById(R.id.anxious_button).setOnClickListener(v ->
                emotions.add(new Emotion("Anxious"))
        );
        view.findViewById(R.id.tired_button).setOnClickListener(v ->
                emotions.add(new Emotion("Tired"))
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