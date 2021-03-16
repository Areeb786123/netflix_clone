package com.example.netflix.retrofit

import com.example.netflix.Model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("marvel")
    fun getMovieList():Call<MutableList<Movie>>
}