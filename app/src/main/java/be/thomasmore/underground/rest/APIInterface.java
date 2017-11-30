package be.thomasmore.underground.rest;

import java.util.List;

import be.thomasmore.underground.classes.Terrorist;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIInterface {

    @GET("/api/terrorists")
    Call<List<Terrorist>> getTerrorists(@Header("Authorization") String accessToken );

    @POST("/api/auth/login")
    Call createUser(@Body String qrCode);

}

