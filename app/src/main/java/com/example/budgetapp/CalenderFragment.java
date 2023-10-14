package com.example.budgetapp;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


import java.text.DateFormat;
import java.util.Calendar;

public class CalenderFragment extends Fragment implements DatePickerDialog.OnDateSetListener{
    @Nullable

    private boolean startDateOrEndDate = true;

    private TextView dateText;
    private TextView jobText;
    DatePickerDialog.OnDateSetListener from_dateListener,to_dateListener;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_calendar, container, false);
        return view;

        //return inflater.inflate(R.layout.fragment_balance, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dateText = view.findViewById(R.id.date_text);
        jobText = view.findViewById(R.id.job_text);

        view.findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDateOrEndDate = true;
                showDatePickerDialog();
            }
        });
        view.findViewById(R.id.job_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDateOrEndDate = false;
                showDatePickerDialog();
            }
        });
    }

    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                getContext(),
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month++;
        String date = "month/day/year: " + month + "/" + dayOfMonth + "/" + year;
        if(startDateOrEndDate){
            dateText.setText(date);
        }else{
            jobText.setText(date);
        }

    }





}
