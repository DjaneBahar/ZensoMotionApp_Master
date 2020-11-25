package com.example.application.toolbarapp.ui.insights;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.application.toolbarapp.R;
import com.example.application.toolbarapp.ui.exercises.ExercisesFragment;
import com.example.application.toolbarapp.ui.home.HomeViewModel;

public class InsightsFragment extends Fragment {

    private InsightsViewModel insightsViewModel;

    public InsightsFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        insightsViewModel =
                ViewModelProviders.of(this).get(InsightsViewModel.class);

        View view = inflater.inflate(R.layout.fragment_insights, container, false);



        final TextView textView = view.findViewById(R.id.text_insights);
        insightsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        return view;
    }
}