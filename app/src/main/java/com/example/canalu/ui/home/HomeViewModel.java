package com.example.canalu.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.canalu.model.AuthenticationData;
import com.example.canalu.model.Users;
import com.example.canalu.request.ApiClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<Users> useri;
    private AuthenticationData authenticationData;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        useri = new MutableLiveData<Users>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public MutableLiveData<Users> getText1() {
        return useri;
    }

   /*  public void getUser(){
        int groupId = 1;
         //mText.setValue("code: no estas logueado");
        Call<Users> call = ApiClient.getMyApiClient().get(groupId);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.isSuccessful()) {

                    Users users = new Users();
                    users = response.body();

                    mText.setValue("Bienvenido "+users.getUsersFirstName()+","+users.getUsersLastName());

                    /*SharedPreferences sharedPreferences = context.getSharedPreferences("token",0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    String tokenValue="Bearer "+response.body();
                    editor.putString("token",tokenValue);
                    editor.commit();

                }else {
                    mText.setValue("codigo:"+response.code());
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                mText.setValue("codigo:"+t);
            }
        });
    }*/
}