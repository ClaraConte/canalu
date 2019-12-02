package com.example.canalu.ui.rutes.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListRoutesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ListRoutesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}