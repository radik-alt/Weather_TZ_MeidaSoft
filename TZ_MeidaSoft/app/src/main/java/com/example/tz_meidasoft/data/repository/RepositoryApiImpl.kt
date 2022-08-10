package com.example.tz_meidasoft.data.repository

import androidx.lifecycle.LiveData
import com.example.tz_meidasoft.data.api.GetDataNetworkImpl
import com.example.tz_meidasoft.data.entity.apiModel.ApiModel
import com.example.tz_meidasoft.domain.entity.apiDomain.ApiDomain
import com.example.tz_meidasoft.domain.repository.RepositoryApi
import retrofit2.Response

class RepositoryApiImpl : RepositoryApi {

    override suspend fun getApiWeather(city: String): Response<ApiDomain> {
        return GetDataNetworkImpl.api.getApiWeather(city)
    }
}