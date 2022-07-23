package com.example.tz_meidasoft.domain.repository

import com.example.tz_meidasoft.data.api.GetDataNetworkImpl
import com.example.tz_meidasoft.data.entity.ApiModel
import retrofit2.Response

class RepositoryApi {

    suspend fun getWeather(): Response<ApiModel>{
        return GetDataNetworkImpl.api.getDataDay()
    }

    suspend fun getWeatherWithParam(
        city: String,
        numberCnt:Int,
        apiKey:String,
        language :String,
        unitsMetric: String
    ): Response<ApiModel>{
        return GetDataNetworkImpl.api.getDataDay2(numberCnt, city, apiKey, language, unitsMetric)
    }
}