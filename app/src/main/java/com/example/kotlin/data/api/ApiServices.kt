package com.example.kotlin.data.api

import com.example.kotlin.data.model.getUserLoginDataResponce.GetUserLoginDataResponce
import retrofit2.Response
import retrofit2.http.*

interface ApiServices {
     @GET("employee/login")
     suspend fun login():Response<GetUserLoginDataResponce>

}