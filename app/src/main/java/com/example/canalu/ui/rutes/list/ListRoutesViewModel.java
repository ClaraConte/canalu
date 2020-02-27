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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListRoutesViewModel extends AndroidViewModel {

    private MutableLiveData<MapsItems> route;
    private MutableLiveData<String> error;

    public ListRoutesViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<MapsItems> getMapsRoutes(){
        if(route == null){
            route = new MutableLiveData<>();
        }
        return route;
    }

    public LiveData<String> getError(){
        if(error == null){
            error = new MutableLiveData<>();
        }
        return error;
    }

    public void getRoutes(){
        int groupId = 1;
        Call<MapsRoutes> call = ApiClient.getMyApiClient().getMapsRoutes(groupId);
        call.enqueue(new Callback<MapsRoutes>() {
            @Override
            public void onResponse(Call<MapsRoutes> call, Response<MapsRoutes> response) {
                if (response.isSuccessful()) {
                    for (MapsItems i : response.body().getMapsItems()
                         ) {
                        route.setValue(i);
                    }
                }else{
                    error.setValue("No se encontraron datos");
                }
            }
            @Override
            public void onFailure(Call<MapsRoutes> call, Throwable t) {
                error.setValue("Error al cargar datos");
            }
        });
    }
}