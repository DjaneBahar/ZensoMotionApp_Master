package com.example.application.toolbarapp;


import android.os.Bundle;
import android.view.View;

import com.example.application.toolbarapp.ui.exercises.ExercisesFragment;
import com.example.application.toolbarapp.ui.home.HomeFragment;
import com.example.application.toolbarapp.ui.insights.InsightsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("et to tre");
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        System.out.println("hej");
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_main,new HomeFragment()).commit();

        int v = R.id.fragment_main;
        System.out.println("ID "+ v );



      //fragmentTransaction.add();
        //fragmentTransaction.commit();

        /*ExercisesFragment exercisesFragment = new ExercisesFragment();
        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction().add(R.id.container,exercisesFragment).commit();
*/

    }

}