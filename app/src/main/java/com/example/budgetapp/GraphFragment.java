package com.example.budgetapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
//added
import android.graphics.Color;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;


public class GraphFragment extends Fragment {
    TextView groceries, rent, maintenance, medical, clothes, entertainment, savings, others, left;
    PieChart pieChart;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_graph, container, false);

        return view;


    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Link those objects with their
        // respective id's that
        // we have given in .XML file
        groceries = view.findViewById(R.id.groceries);
        rent = view.findViewById(R.id.rent);
        maintenance = view.findViewById(R.id.maintenance);
        medical = view.findViewById(R.id.medical);
        clothes = view.findViewById(R.id.clothes);
        entertainment = view.findViewById(R.id.entertainment);
        savings = view.findViewById(R.id.savings);
        others = view.findViewById(R.id.others);
        left = view.findViewById(R.id.left);
        pieChart = view.findViewById(R.id.piechart);


        // Creating a method setData()
        // to set the text in text view and pie chart
        setData();

    }
    private void setData()
    {

        Bundle bundle = this.getArguments();

        int groceries_data = bundle.getInt("key_groceries");
        int rent_data = bundle.getInt("key_rent");
        int maintenance_data = bundle.getInt("key_maintenance");
        int medical_data = bundle.getInt("key_medical");
        int clothes_data = bundle.getInt("key_clothes");
        int entertainment_data = bundle.getInt("key_entertainment");
        int savings_data = bundle.getInt("key_savings");
        int others_data = bundle.getInt("key_others");
        int total_data = bundle.getInt("key_total");
        int left_data = bundle.getInt("key_left");


        groceries.setText(Integer.toString(groceries_data));
        rent.setText(Integer.toString(rent_data));
        maintenance.setText(Integer.toString(maintenance_data));
        medical.setText(Integer.toString(medical_data));
        clothes.setText(Integer.toString(clothes_data));
        entertainment.setText(Integer.toString(entertainment_data));
        savings.setText(Integer.toString(savings_data));
        others.setText(Integer.toString(others_data));
        left.setText(Integer.toString(left_data));


        // Set the data and color to the pie chart
        pieChart.addPieSlice(
                new PieModel(
                        "Groceries",
                        Integer.parseInt(groceries.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Rent",
                        Integer.parseInt(rent.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Maintenance",
                        Integer.parseInt(maintenance.getText().toString()),
                        Color.parseColor("#00BCD4")));
        pieChart.addPieSlice(
                new PieModel(
                        "Medical Car",
                        Integer.parseInt(medical.getText().toString()),
                        Color.parseColor("#673AB7")));

        pieChart.addPieSlice(
                new PieModel(
                        "Clothes",
                        Integer.parseInt(clothes.getText().toString()),
                        Color.parseColor("#9C27B0")));
        pieChart.addPieSlice(
                new PieModel(
                        "Entertainment",
                        Integer.parseInt(entertainment.getText().toString()),
                        Color.parseColor("#CDDC39")));
        pieChart.addPieSlice(
                new PieModel(
                        "Savings",
                        Integer.parseInt(savings.getText().toString()),
                        Color.parseColor("#E91E63")));
        pieChart.addPieSlice(
                new PieModel(
                        "Others",
                        Integer.parseInt(others.getText().toString()),
                        Color.parseColor("#3F51B5")));
        pieChart.addPieSlice(
                new PieModel(
                        "Money Left",
                        Integer.parseInt(left.getText().toString()),
                        Color.parseColor("#6D97AA")));
        // To animate the pie chart
        pieChart.startAnimation();
    }

}
