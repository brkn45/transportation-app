package com.example.singup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GetDataService {
    @POST("singup")
    public Call<User> addUser(@Body User user);

    @POST("auth")
    public Call<SuccessEntity> AuthFun(@Body Auth auth);

    @POST("addbus")
    public  Call<Integer> busFun(@Body BusFeature busFeature);

    @POST("joinbus")
    public Call<String> joinBus(@Body JoinBus joinBus);

    @POST("allpassenger")
    public Call<ArrayList<User>> requestAllPerson(@Body DriverId driverId);
}
