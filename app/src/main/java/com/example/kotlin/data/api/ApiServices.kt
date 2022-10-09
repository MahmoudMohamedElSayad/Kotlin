package com.example.kotlin.data.api

import com.example.kotlin.data.model.getUserLoginDataResponce.GetUserLoginDataResponce
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiServices {
    @POST("customer/login")
    @FormUrlEncoded
    fun login(
        @Field("phone") phone: String, @Field("password") password: String
    ):Call<GetUserLoginDataResponce>

}