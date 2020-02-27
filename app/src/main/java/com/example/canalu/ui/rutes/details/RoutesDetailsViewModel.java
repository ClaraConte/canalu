package com.example.canalu.ui.rutes.details;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.canalu.model.MapsItems;
import com.example.canalu.request.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoutesDetailsViewModel extends ViewModel {

    private MutableLiveData <MapsItems> mapsItems;
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

    public void saveDetails(MapsItems items){

        int id = items.getIdMapsItems();
        Call<MapsItems> call = ApiClient.getMyApiClient().putMapsItems(id,items);

        call.enqueue(new Callback<MapsItems>() {
            @Override
            public void onResponse(Call<MapsItems> call, Response<MapsItems> response) {

                if (response.isSuccessful()) {
                    mapsItems.postValue(response.body());
                    Log.d("ver","si");
                }else{
                    error.postValue("Error al cargar datos");
                }
            }
            @Override
            public void onFailure(Call<MapsItems> call, Throwable t) {
                error.postValue(t.toString());
            }
        });
    }
}
