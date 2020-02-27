package com.example.canalu.ui.orders;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.canalu.model.MapsItems;
import com.example.canalu.model.MapsRoutes;
import com.example.canalu.model.Orders;
import com.example.canalu.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdersViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Orders>> orders;
    private MutableLiveData<String> error;

    public LiveData<ArrayList<Orders>> getOrders(){
        if(orders == null){
            orders = new MutableLiveData<ArrayList<Orders>>();
        }
        return orders;
    }

    public LiveData<String> getError(){
        if(error == null){
            error = new MutableLiveData<>();
        }
        return error;
    }
    public void getOrdersData(){
        int groupId = 1;
        Call<ArrayList<Orders>> call = ApiClient.getMyApiClient().getOrdersList(groupId);
        //System.out.println();
        call.enqueue(new Callback<ArrayList<Orders>>() {
            @Override
            public void onResponse(Call<ArrayList<Orders>> call, Response<ArrayList<Orders>> response) {
                if (response.isSuccessful()) {
                    orders.setValue(response.body());
                }else{
                    error.setValue("No se encontraron datos");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Orders>> call, Throwable t) {
                error.setValue("Error al cargar datos");
            }
        });
    }
}