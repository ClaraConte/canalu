package com.example.canalu.ui.orders.create;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.canalu.model.MapsItems;
import com.example.canalu.model.MapsRoutes;
import com.example.canalu.model.Orders;
import com.example.canalu.model.Products;
import com.example.canalu.request.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateOrderViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Products>> route;
    private MutableLiveData<String> error;

    public CreateOrderViewModel(@NonNull Application application) {
        super(application);
    }
    public MutableLiveData<ArrayList<Products>> getProducts(){
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

    public void getProductsDetails(){
        Call<ArrayList<Products>> call = ApiClient.getMyApiClient().getProducts();
        call.enqueue(new Callback<ArrayList<Products>>() {
            @Override
            public void onResponse(Call<ArrayList<Products>> call, Response<ArrayList<Products>> response) {
                if (response.isSuccessful()) {

                        route.setValue(response.body());

                }else{
                    error.setValue("No se encontraron datos");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Products>> call, Throwable t) {
                error.setValue("Error al cargar datos");
            }
        });
    }

    public void putUser(Orders orders){
        int id = 1;
        Call<Orders> call = ApiClient.getMyApiClient().createOrder(orders);

        call.enqueue(new Callback<Orders>() {
            @Override
            public void onResponse(Call<Orders> call, Response<Orders> response) {

                if (response.isSuccessful()) {
                    error.setValue("Orden creada");

                }else{
                    error.setValue("Error al crear orden");
                }
            }
            @Override
            public void onFailure(Call<Orders> call, Throwable t) {

            }
        });
    }
}
