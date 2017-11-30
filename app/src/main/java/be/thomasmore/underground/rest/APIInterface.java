package be.thomasmore.underground.rest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("/api/auth/login")
    Call createUser(@Body String qrCode);

}

