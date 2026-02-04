package com.example.Dxiang1_Emotilog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class EditButtonFragment extends DialogFragment {
    /*This fragment is for changing the customizable buttons through
    * a dialog fragment and edit texts. it changes the names array
    * to do so*/
    private String[] emotionsNames;
    private static final String ARGS_STRING_ARRAY = "emotionsNames";
    public EditButtonFragment() {

    }

    public static EditButtonFragment newInstance(String[] emotionsNames) {
        /*for stable importing of the names array after
        * null array errors*/
        EditButtonFragment fragment = new EditButtonFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARGS_STRING_ARRAY, emotionsNames);
        fragment.setArguments(args);
        return fragment;
    }


    public interface EditButtonDialogListener {
        //for editing the button names
        void editButton(String[] emotionsNames);
    }

    private EditButtonDialogListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        //making sure the fragment is attached to firstfragment
        super.onAttach(context);

        Fragment parent = getParentFragment();
        if (parent instanceof EditButtonDialogListener) {
            listener = (EditButtonDialogListener) parent;
        } else {
            throw new RuntimeException(context + " must implement EditButtonDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        /*large boy, this thing has to get all 6 editTexts from the proper
        * xml and then hook them up to get the texts out of them and
        * into the emotions names array*/
        emotionsNames = getArguments().getStringArray(ARGS_STRING_ARRAY);


        View view = LayoutInflater.from(getContext()).inflate(R.layout.edit_button_fragment, null);
        EditText editHappy = view.findViewById(R.id.edit_happy_button);
        EditText editSad = view.findViewById(R.id.edit_sad_button);
        EditText editAngry = view.findViewById(R.id.edit_angry_button);
        EditText editAnxious = view.findViewById(R.id.edit_anxious_button);
        EditText editCalm = view.findViewById(R.id.edit_calm_button);
        EditText editTired = view.findViewById(R.id.edit_tired_button);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder
                .setView(view)
                .setTitle("Customize Buttons")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Customize", (dialog, which) -> {
                    emotionsNames[0] = editHappy.getText().toString();
                    emotionsNames[1] = editSad.getText().toString();
                    emotionsNames[2] = editAngry.getText().toString();
                    emotionsNames[3] = editAnxious.getText().toString();
                    emotionsNames[4] = editCalm.getText().toString();
                    emotionsNames[5] = editTired.getText().toString();
                    listener.editButton(emotionsNames);
                })
                .create();
    }
}
