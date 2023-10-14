package com.example.budgetapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    public BottomNavigationView bottomNav;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);




        //added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }


    }

    private NavigationBarView.OnItemSelectedListener navListener =
            new BottomNavigationView.OnItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;//used to default to home
                    if(item.getItemId() == R.id.nav_home){

                        selectedFragment = new HomeFragment();



                    }else if(item.getItemId() == R.id.nav_input){

                        selectedFragment = new InputFragment();


                    }else if(item.getItemId() == R.id.nav_calendar) {
                        selectedFragment = new CalenderFragment();

                    }
                    if(selectedFragment == null) selectedFragment = new HomeFragment();
                    String backStateName = selectedFragment.getClass().getName();
                    getSupportFragmentManager().beginTransaction().addToBackStack(backStateName).replace(R.id.fragment_container,
                            selectedFragment, "tag").commit();

                    return true;
                }
            };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        } else {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void setOnItemReselectedListener (NavigationBarView.OnItemReselectedListener listener){
        Toast.makeText(MainActivity.this, "Reselected", Toast.LENGTH_SHORT).show();
    }



}