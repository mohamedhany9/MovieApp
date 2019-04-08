package com.example.movieapp.Client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {


    companion object {
    val BASE_URL: String = "http://api.themoviedb.org/3/"
    var retrofit: Retrofit? = null


    fun getclient(): Retrofit {


        if (retrofit == null) {
           retrofit= Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit!!
        } else {
            return retrofit!!
        }
    }
}}