package com.example.budgetapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

public class BalanceFragment extends Fragment {
    @Nullable


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_balance, container, false);
        return view;

        //return inflater.inflate(R.layout.fragment_balance, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Link those objects with their
        // respective id's that
        // we have given in .XML file


        Bundle bundle = this.getArguments();
        if(bundle!=null){
            int total_data = bundle.getInt("key_total_balance");


            int left_data = bundle.getInt("key_left_balance");
            int spent = total_data - left_data;
            ((TextView) view.findViewById(R.id.display_total)).setText(String.valueOf(total_data)+"$");
            ((TextView) view.findViewById(R.id.display_balance)).setText(String.valueOf(left_data)+"$");
            ((TextView) view.findViewById(R.id.display_spent)).setText(String.valueOf(spent)+"$");
        }







    }

}
