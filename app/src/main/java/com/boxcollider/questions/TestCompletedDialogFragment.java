package com.boxcollider.questions;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by aleksander on 3/18/15.
 */
public class TestCompletedDialogFragment extends DialogFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE,0);

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

       View v= getActivity().getLayoutInflater().inflate(R.layout.test_completed_dialog,null,false);
       View yesButton= v.findViewById(R.id.answerYes);
        View noButton = v.findViewById(R.id.answerNo);


        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setView(v);

        // Create the AlertDialog object and return it
        return builder.create();
    }


   // @Override
    public View monCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.test_completed_dialog, container, false);
        View yesButton= v.findViewById(R.id.answerYes);
        View noButton = v.findViewById(R.id.answerNo);


        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return v;
    }
}
