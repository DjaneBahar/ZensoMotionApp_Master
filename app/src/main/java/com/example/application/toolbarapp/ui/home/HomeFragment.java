package com.example.application.toolbarapp.ui.home;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    private ImageView profileImage;
    private ImageView exercisesImage;
    private ImageView insightsImage;
    private TextView showTextView;

    public HomeFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        View view = inflater.inflate(R.layout.fragment_home, container, false);



        profileImage  = view.findViewById(R.id.profile_image);
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_container,new ProfileFragment());
                transaction.commit();
            }
        });


        exercisesImage = view.findViewById(R.id.exercises_image);
        exercisesImage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_main, new ExercisesFragment());
                transaction.commit();

            }

        });

        insightsImage = view.findViewById(R.id.insights_image);
        insightsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment f = new InsightsFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_main,f);
                fragmentTransaction.commit();

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