package com.example.kotlin.data.model.getUserLoginDataResponce

data class GetUserLoginDataResponce(
    val code: Int,
    val count: Any,
    val data: Data,
    val message: String,
    val paginate: Any,
    val status: String
)