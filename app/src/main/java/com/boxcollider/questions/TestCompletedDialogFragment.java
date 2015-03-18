package com.boxcollider.questions;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;

/**
 * Created by aleksander on 3/18/15.
 */
public class TestCompletedDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
       View v= getActivity().getLayoutInflater().inflate(R.layout.test_completed_dialog,null,false);
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
