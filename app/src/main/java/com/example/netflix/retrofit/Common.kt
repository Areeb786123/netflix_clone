package com.example.netflix.retrofit

import retrofit2.create

object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"

    val retrofitService: RetrofitService
        get()= RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}