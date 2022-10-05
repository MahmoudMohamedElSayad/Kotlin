package com.example.kotlin.data.model.getUserLoginDataResponce

data class Data(
    val addresses: List<Addresse>,
    val container_rentals_count: Int,
    val contracts_count: Int,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val token: String
)