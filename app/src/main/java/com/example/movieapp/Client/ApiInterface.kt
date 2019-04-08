package com.example.movieapp.Client

import com.example.movieapp.model.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("movie/popular")
   fun getPopularMovies(@Query("api_key") apiKey :  String):Call<MoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey :  String):Call<MoviesResponse>

    @GET("movie/upcoming")
    fun getLatestMovies(@Query("api_key") apiKey :  String):Call<MoviesResponse>
}