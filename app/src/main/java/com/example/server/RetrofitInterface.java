package com.example.server;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.PUT;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

//    @PUT("/member/register")
//    @GET("/member/register")
    // 멤버 인터페이스

    @PUT("member/register")
    Call<Member> registerMember(@Query("id") String id,
                                @Query("pw") String pw,
                                @Query("name") String name,
                                @Query("phone") String phone);

    @GET("member/loginform")
    Call<Member> login(@Query("id") String id,
                       @Query("pw") String pw);





    // 약국 인터페이스

    @GET("pharmacy/all")
    Call<List<Pharmacy>> getPharmacyList();

    @GET("pharmacy/{id}")
    Call<List<Pharmacy>> getPharmacy();

}