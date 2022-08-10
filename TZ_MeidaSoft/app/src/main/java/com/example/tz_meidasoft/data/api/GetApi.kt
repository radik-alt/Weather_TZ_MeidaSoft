package com.example.tz_meidasoft.data.api

import androidx.lifecycle.LiveData
import com.example.tz_meidasoft.data.entity.apiModel.ApiModel
import com.example.tz_meidasoft.domain.entity.apiDomain.ApiDomain
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetApi {

    @GET("data/2.5/forecast/daily?cnt=7&appid=87dcdc26b0bccc33955d2e4e2cf87795&lang=ru&units=metric")
    suspend fun getApiWeather(
        @Query("q") chooseCity: String
    ):Response<ApiDomain>

}