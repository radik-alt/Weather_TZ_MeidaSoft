package com.example.tz_meidasoft.data.api

import com.example.tz_meidasoft.data.entity.ApiModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface GetApi {

    @GET("data/2.5/forecast/daily?q=Ulyanovsk,8422&cnt=1&appid=87dcdc26b0bccc33955d2e4e2cf87795&lang=ru&units=metric")
    suspend fun getDataDay():Response<ApiModel>
}