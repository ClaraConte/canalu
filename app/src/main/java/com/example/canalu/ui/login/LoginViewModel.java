package com.example.canalu.ui.login;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.canalu.R;
import com.example.canalu.model.AuthenticationData;
import com.example.canalu.model.Employees;
import com.example.canalu.model.Login;
import com.example.canalu.model.Users;
import com.example.canalu.request.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.provider.Settings.System.getString;


public class LoginViewModel extends AndroidViewModel {

    private MutableLiveData<String> error;
    private MutableLiveData<String> errorLogOut;
    private MutableLiveData<String> token;

    private Context context;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public MutableLiveData<String> getToken(){
        if(token == null){
            token = new MutableLiveData<>();
        }
        return token;
    }

    public LiveData<String> getError(){
        if(error == null){
            error = new MutableLiveData<>();
        }
        return error;
    }

    public LiveData<String> getErrorLogOut(){
        if(errorLogOut == null){
            errorLogOut = new MutableLiveData<>();
        }
        return errorLogOut;
    }

    public void sendPost(Login login) {

        Call<Employees> call = ApiClient.getMyApiClient().post(login);
        call.enqueue(new Callback<Employees>() {
            @Override
            public void onResponse(Call<Employees> call, Response<Employees> response) {

                if (response.isSuccessful()) {
                    AuthenticationData.getInstance().setToken(response.body().getEmployeesKey());
                    token.postValue(AuthenticationData.getInstance().getToken());
                    /*SharedPreferences sharedPreferences = context.getSharedPreferences("token",0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    String tokenValue="Bearer "+response.body();
                    editor.putString("token",tokenValue);
                    editor.commit();*/

                }else{
                    if(response.code() == 400) {
                        error.postValue("Usuario o contraseña incorrecto");
                    }else {
                        error.postValue("Error de servidor");
                    }
                }
            }

            @Override
            public void onFailure(Call<Employees> call, Throwable t) {
                //error.postValue(t.toString());
                error.postValue("Error al conectarse con el servidor");
            }
        });
    }

   public void setError(Boolean logOut){
        if(logOut){
             //getApplication().getString(R.string.error_session_finish);
            errorLogOut.postValue("Su sesión a expirado, vuelva a ingresar");
        }
   }

}
