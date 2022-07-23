package com.example.tz_meidasoft.data.api

import com.example.tz_meidasoft.data.entity.ApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetApi {

    @GET("data/2.5/forecast/daily?q=Ulyanovsk&cnt=1&appid=87dcdc26b0bccc33955d2e4e2cf87795&lang=ru&units=metric")
    suspend fun getDataDay():Response<ApiModel>


    @GET("data/2.5/forecast/daily?cnt={cnt}")
    suspend fun getDataDay2(
        @Path("cnt") numberCnt:Int,
        @Query("q") chooseCity: String,
        @Query("appid") apiKey:String,
        @Query("lang") language :String,
        @Query("units") unitsMetric: String

    ):Response<ApiModel>

}