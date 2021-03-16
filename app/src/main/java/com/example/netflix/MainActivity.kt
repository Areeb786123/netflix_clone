package com.example.netflix

import android.annotation.SuppressLint
import android.app.Service
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.netflix.Adapter.Adapter
import com.example.netflix.Model.Movie
import com.example.netflix.retrofit.Common
import com.example.netflix.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    lateinit var mService: RetrofitService
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: Adapter
    lateinit var layoutManager: LinearLayoutManager

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView= findViewById(R.id.recycler_view)


        mService = Common.retrofitService

        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this,OrientationHelper.HORIZONTAL,false)
        recyclerView.layoutManager = layoutManager

        getAllMovies()


    }

    private fun getAllMovies() {
        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>> {
            override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>) {
                adapter = Adapter(baseContext, response.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter

            }

            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT)
            }

        })
    }
}




