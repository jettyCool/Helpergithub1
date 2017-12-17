package com.example.admin.helper.Interface;

import com.example.admin.helper.Models.Geocoder.GeocoderApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Admin on 12/8/2017.
 */

public interface ApiInterface {

    @GET("geocode/json")
    Call<GeocoderApiResponse> getGeocoderApiResponse(@Query("latlng") String latlng, @Query ("sensor") Boolean sensor);

}
