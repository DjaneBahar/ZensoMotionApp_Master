package com.example.application.toolbarapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.application.toolbarapp.R;

import com.example.application.toolbarapp.ui.exercises.ExercisesFragment;
import com.example.application.toolbarapp.ui.exercises.ExercisesViewModel;
import com.example.application.toolbarapp.ui.insights.InsightsFragment;
import com.example.application.toolbarapp.ui.profile.ProfileFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Button exercisesBtn;
    private Button profileBtn;
    private Button insightsBtn;

    public HomeFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        profileBtn = view.findViewById(R.id.profile_btn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragment profileFragment = new ProfileFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.homeLayout,profileFragment);
                transaction.commit();
            }
        });


        exercisesBtn = view.findViewById(R.id.exercises_btn);
        exercisesBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                ExercisesFragment exercisesFragment = new ExercisesFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.homeLayout,exercisesFragment);
                transaction.commit();

            }

        });

        insightsBtn = view.findViewById(R.id.insights_btn);
        insightsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InsightsFragment insightsFragment = new InsightsFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.homeLayout,insightsFragment);
                transaction.commit();
            }
        });


        final TextView textView = view.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });








        return view;
    }
}