package com.example.canalu.ui.main;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.canalu.model.Users;
import com.example.canalu.request.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<Users> usuario;
    private Context context;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Users> getUsuarios(){
        if(usuario == null){
            usuario = new MutableLiveData<Users>();
        }
        return usuario;
    }

    public void getUser(){
        Integer groupId = 1;
        Users resultado = new Users();
        resultado.setUsersFirstName("clara");
        usuario.postValue(resultado);
        Call<Users> call = ApiClient.getMyApiClient().get(groupId);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.isSuccessful()) {
                    Users resultado = new Users();
                    resultado = response.body();
                    usuario.postValue(resultado);
                }else{

                }
            }
            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Log.d("err", String.valueOf(t));
            }
        });
    }
}
