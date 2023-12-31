package com.example.budgetapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.app.DialogFragment;


import androidx.annotation.NonNull;

import java.util.Calendar;


public class DatePickerFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) this, year, month,day);
    }
}