package com.example.tz_meidasoft.model.repository

import com.example.tz_meidasoft.data.api.GetDataNetworkImpl
import com.example.tz_meidasoft.data.entity.ApiModel
import retrofit2.Response

class RepositoryApi {

    suspend fun getWeather(): Response<ApiModel>{
        return GetDataNetworkImpl.api.getDataDay()
    }

}