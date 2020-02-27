package com.example.canalu.ui.customers.details;

import android.os.Parcelable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.canalu.model.MapsItems;

import java.util.ArrayList;

public class  CustomersDetailsViewModel extends ViewModel {

    private MutableLiveData<MapsItems> mapsItems;
    private MutableLiveData <String> error;


    public LiveData<MapsItems> getMapsItems() {

        if(mapsItems == null){
            mapsItems = new MutableLiveData<>();
        }
        return mapsItems;
    }

    public MutableLiveData<String> getError(){
        if(error == null ){
            error = new MutableLiveData<>();
        }
        return error;
    }

    public void getDetails(MapsItems items){

        mapsItems.setValue(items);
    }

}

