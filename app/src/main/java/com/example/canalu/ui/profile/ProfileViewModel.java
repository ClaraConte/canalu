package com.example.canalu.ui.profile;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.canalu.model.Users;
import com.example.canalu.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileViewModel extends AndroidViewModel {

    private MutableLiveData<Users> usuario;
    private Context context;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Users> getUsuarios(){
        if(usuario == null){
            usuario = new MutableLiveData<>();
        }
        return usuario;
    }

    public void getUser(){
        //String token1 = AuthenticationData.getInstance().getToken();
        int groupId = 1;
        Call<Users> call = ApiClient.getMyApiClient().get(groupId);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.isSuccessful()) {
                    usuario.postValue(response.body());
                }else{

                }
            }
            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });
    }
}