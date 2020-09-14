package com.example.price.api;

import com.example.price.model.PriceData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("v2/assets")
    Call<PriceData> getTopPrices();
}
