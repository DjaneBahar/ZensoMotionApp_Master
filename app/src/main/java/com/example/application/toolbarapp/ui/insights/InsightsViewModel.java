package com.example.application.toolbarapp.ui.insights;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InsightsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InsightsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is insights Fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}