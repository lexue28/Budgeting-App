package com.example.budgetapp;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.io.Serializable;
import java.util.List;

public class InputFragment extends Fragment {
    EditText edit_total, edit_groceries, edit_rent, edit_maintenance, edit_medical, edit_clothes, edit_entertainment, edit_savings, edit_others, edit_left;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_input, container, false);
        super.onViewCreated(view, savedInstanceState);



        Button button = view.findViewById(R.id.button);
        Button bankButton = view.findViewById(R.id.bankButton);
        edit_total = view.findViewById(R.id.text_total);
        edit_groceries = view.findViewById(R.id.text_groceries);
        edit_rent = view.findViewById(R.id.text_rent);
        edit_maintenance = view.findViewById(R.id.text_maintenance);
        edit_medical = view.findViewById(R.id.text_medical);
        edit_clothes = view.findViewById(R.id.text_clothes);
        edit_entertainment = view.findViewById(R.id.text_entertainment);
        edit_savings = view.findViewById(R.id.text_savings);
        edit_others = view.findViewById(R.id.text_others);




        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();



                    bundle.putInt("key_total", Math.max(Integer.parseInt(edit_total.getText().toString()), 0));
                    bundle.putInt("key_groceries", Math.max(Integer.parseInt(edit_groceries.getText().toString()), 0));
                    bundle.putInt("key_rent", Math.max(Integer.parseInt(edit_rent.getText().toString()), 0));
                    bundle.putInt("key_maintenance", Math.max(Integer.parseInt(edit_maintenance.getText().toString()), 0));
                    bundle.putInt("key_medical", Math.max(Integer.parseInt(edit_medical.getText().toString()), 0));
                    bundle.putInt("key_clothes", Math.max(Integer.parseInt(edit_clothes.getText().toString()), 0));
                    bundle.putInt("key_entertainment", Math.max(Integer.parseInt(edit_entertainment.getText().toString()), 0));
                    bundle.putInt("key_savings", Math.max(Integer.parseInt(edit_savings.getText().toString()), 0));
                    bundle.putInt("key_others", Math.max(Integer.parseInt(edit_others.getText().toString()), 0));

                    int left = Integer.parseInt(edit_total.getText().toString()) - Integer.parseInt(edit_groceries.getText().toString()) - Integer.parseInt(edit_rent.getText().toString()) - Integer.parseInt(edit_maintenance.getText().toString()) - Integer.parseInt(edit_medical.getText().toString()) - Integer.parseInt(edit_clothes.getText().toString()) - Integer.parseInt(edit_entertainment.getText().toString()) - Integer.parseInt(edit_savings.getText().toString()) - Integer.parseInt(edit_others.getText().toString());

                    bundle.putInt("key_left", left);
                    GraphFragment fragment = new GraphFragment();
                    fragment.setArguments(bundle);


                    String backStateName = this.getClass().getName();
                    getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(backStateName).replace(R.id.fragment_container, fragment).commit();
                }

            });

        bankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();

                int left = Integer.parseInt(edit_total.getText().toString()) - Integer.parseInt(edit_groceries.getText().toString()) - Integer.parseInt(edit_rent.getText().toString()) - Integer.parseInt(edit_maintenance.getText().toString()) - Integer.parseInt(edit_medical.getText().toString()) - Integer.parseInt(edit_clothes.getText().toString()) - Integer.parseInt(edit_entertainment.getText().toString()) - Integer.parseInt(edit_savings.getText().toString()) - Integer.parseInt(edit_others.getText().toString());
                BalanceFragment balanceFragment = new BalanceFragment();
                Bundle balanceBundle = new Bundle();
                balanceBundle.putInt("key_total_balance", Math.max(Integer.parseInt(edit_total.getText().toString()), 0));
                balanceBundle.putInt("key_left_balance", Math.max(left, 0));
                balanceFragment.setArguments(balanceBundle);






                String backStateName = this.getClass().getName();
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(backStateName).replace(R.id.fragment_container, balanceFragment).commit();
            }

        });
        return view;


    }





}
