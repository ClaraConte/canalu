package com.example.canalu.ui.rutes.maps;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MapsRoutesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MapsRoutesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Esta vista debe mostrar mapa con direcciones");
    }

    public LiveData<String> getText() {
        return mText;
    }
}