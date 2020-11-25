package com.example.application.toolbarapp.ui.resistance;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ResistanceViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ResistanceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is resistance fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}