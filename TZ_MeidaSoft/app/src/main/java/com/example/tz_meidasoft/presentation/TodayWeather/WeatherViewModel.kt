package com.example.tz_meidasoft.presentation.TodayWeather

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tz_meidasoft.data.entity.ApiModel
import com.example.tz_meidasoft.model.repository.RepositoryApi
import kotlinx.coroutines.*
import retrofit2.Response

class WeatherViewModel() : ViewModel() {

    private val repositoryApi: RepositoryApi = RepositoryApi()
    val response: MutableLiveData<Response<ApiModel>> = MutableLiveData()


    fun getWeather() {
        viewModelScope.launch {
            response.value = repositoryApi.getWeather()
            Log.d("GetApiWeather", repositoryApi.getWeather().toString())
        }
    }

}