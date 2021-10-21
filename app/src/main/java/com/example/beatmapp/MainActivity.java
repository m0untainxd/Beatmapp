package com.example.beatmapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bnv = findViewById(R.id.bottomNavigationView);
        bnv.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        NavController navController = Navigation.findNavController(findViewById(R.id.fragmentContainerView));
        int currentFragmentID = navController.getCurrentDestination().getId();

        if (item.getItemId() == R.id.miBottomNavSearch){
            if (currentFragmentID != R.id.beatmapFragment){
                navController.navigate(R.id.beatmapFragment);
            }
            return true;
        }
        else if (item.getItemId() == R.id.miBottomNavPerformance) {
            if (currentFragmentID != R.id.performanceFragment) {
                navController.navigate(R.id.performanceFragment);
            }
            return true;
        }
        else if (item.getItemId() == R.id.miBottomNavHome) {
            if (currentFragmentID != R.id.searchFragment) {
                navController.navigate(R.id.searchFragment);
            }
            return true;
        }
        return false;
    }
}