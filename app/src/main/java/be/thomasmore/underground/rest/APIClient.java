package be.thomasmore.underground.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by robyd on 30/11/2017.
 */

public class APIClient {
        private static Retrofit retrofit = null;

    public static Retrofit getClient() {


        retrofit = new Retrofit.Builder()
                .baseUrl("http://37.230.98.71/htf/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        return retrofit;
    }
}
