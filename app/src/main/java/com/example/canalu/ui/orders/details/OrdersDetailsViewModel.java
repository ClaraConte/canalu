package com.example.canalu.ui.orders.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.canalu.model.Orders;
import com.example.canalu.model.OrdersDetails;
import com.example.canalu.request.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdersDetailsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<OrdersDetails>> orders;
    private MutableLiveData<String> error;
    private MutableLiveData<String> totalAmount;
    private MutableLiveData<String> dateOreder;

    public LiveData<ArrayList<OrdersDetails>> getOrdersDetails(){
        if(orders == null){
            orders = new MutableLiveData<ArrayList<OrdersDetails>>();
        }
        return orders;
    }

    public LiveData<String> getError(){
        if(error == null){
            error = new MutableLiveData<>();
        }
        return error;
    }

    public LiveData<String> getTotalAmount(){
        if(totalAmount == null){
            totalAmount = new MutableLiveData<>();
        }
        return totalAmount;
    }
    public void updateOrdersDetails(){

    }

    public void setOrdersDetails(ArrayList<OrdersDetails> ordersDetails){
        orders.setValue(ordersDetails);

        double total=0;
        for (OrdersDetails i: ordersDetails) {
            total += i.getOrdersDetailsTotalProducts()*i.getProducts().getProductsUnitPrice();
        }
          totalAmount.setValue(total+"");
    }

    public void getDateOrder(){}
}