package com.example.tz_meidasoft.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GetDataNetworkImpl {

    private const val BASE_URL_WEATHER = "https://api.openweathermap.org/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_WEATHER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : GetApi by lazy {
        retrofit.create(GetApi::class.java)
    }
}