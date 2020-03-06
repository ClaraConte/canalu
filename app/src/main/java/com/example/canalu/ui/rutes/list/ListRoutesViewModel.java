package com.example.canalu.ui.rutes.list;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.canalu.model.MapsItems;
import com.example.canalu.model.MapsRoutes;
import com.example.canalu.request.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListRoutesViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<MapsItems>> routes;
    private MutableLiveData<String> error;
    private MutableLiveData<Boolean> login;

    public ListRoutesViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<MapsItems>> getMapsRoutes(){
        if(routes == null){
            routes = new MutableLiveData<ArrayList<MapsItems>>();
        }
        return routes;
    }

    public LiveData<String> getError(){
        if(error == null){
            error = new MutableLiveData<>();
        }
        return error;
    }

    public LiveData<Boolean> goToLogin(){
        if(login == null){
            login = new MutableLiveData<>();
        }
        return login;
    }

    public void getRoutes(){
        int groupId = 1;
        Call<MapsRoutes> call = ApiClient.getMyApiClient().getMapsRoutes(groupId);
        call.enqueue(new Callback<MapsRoutes>() {
            @Override
            public void onResponse(Call<MapsRoutes> call, Response<MapsRoutes> response) {
                if (response.isSuccessful()) {
                    routes.setValue(response.body().getMapsItems());
                }else{
                    if(response.code() == 401){
                        login.setValue(true);
                    }
                }
            }
            @Override
            public void onFailure(Call<MapsRoutes> call, Throwable t) {
                error.setValue("Error al cargar datos");
            }
        });
    }
}