package com.example.canalu.request;

import android.util.Log;

import androidx.annotation.RawRes;

import com.example.canalu.model.AuthenticationData;
import com.example.canalu.model.Employees;
import com.example.canalu.model.Login;
import com.example.canalu.model.MapsItems;
import com.example.canalu.model.MapsRoutes;
import com.example.canalu.model.Orders;
import com.example.canalu.model.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class ApiClient {
    //private static final String PATH ="http://192.168.0.18:45455/api/"; Server

    private static final String PATH ="http://192.168.0.17:45455/api/";

    //private static final String PATH ="http://10.152.112.193:45455/api/"; ulp

    //private static final String PATH ="http://192.168.0.30:45455/api/"; MZa

    private static  MyApiInterface myApiInterface;

    public static MyApiInterface getMyApiClient(){

        Gson gson = new GsonBuilder().setLenient().create();

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                String token = AuthenticationData.getInstance().getToken();
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + token)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(PATH)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

        myApiInterface =retrofit.create(MyApiInterface.class);
        return myApiInterface;

    }

    public interface MyApiInterface  {
        /*@FormUrlEncoded
        @PUT("propietario/{id}")
        Call<Propietario> actualizar(@Header("Authorization")String token, @Path("id") int groupId, @Field("Nombre")String nombre,@Field("Apellido") String*/

        @POST("Users/")
        Call<Employees> post(@Body Login login);

        @GET("Users/{id}")
        Call<Users> get(@Path("id") int groupId);

        @PUT("Users/{id}")
        Call<Users> put(@Path("id") int id, @Body Users users);

        @GET("MapsRoutes/{id}")
        Call<MapsRoutes> getMapsRoutes(@Path("id") int groupId);

        @PUT("MapsRoutes/{id}")
        Call<MapsItems> putMapsItems(@Path("id") int id, @Body MapsItems mapsItems);

        @GET("Orders/{id}")
        Call <ArrayList<Orders>> getOrdersList(@Path("id") int groupId);
    }
}
