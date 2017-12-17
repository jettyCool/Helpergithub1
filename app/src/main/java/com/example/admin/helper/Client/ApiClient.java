package com.example.admin.helper.Client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 12/8/2017.
 */

public class ApiClient {

    public static final String  BASE_URL="https://maps.googleapis.com/maps/api/";
    public static Retrofit retrofit;

    public  static Retrofit getApiClient2(){

        if (retrofit==null){

            retrofit=new Retrofit.Builder().
                    baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }


}
