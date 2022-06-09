package com.example.server;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.PUT;
import retrofit2.http.GET;

public interface RetrofitInterface {

//    @PUT("/member/register")
//    @GET("/member/register")
    @GET("pharmacy/all")
    Call<List<Pharmacy>> getPharmacyList();

    @GET("pharmacy/{id}")
    Call<List<Pharmacy>> getPharmacy();

}