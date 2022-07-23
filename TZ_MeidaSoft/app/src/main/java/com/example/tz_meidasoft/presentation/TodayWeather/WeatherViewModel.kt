package com.example.tz_meidasoft.presentation.TodayWeather

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tz_meidasoft.data.entity.ApiModel
import com.example.tz_meidasoft.domain.repository.RepositoryApi
import kotlinx.coroutines.*
import retrofit2.Response

class WeatherViewModel(application: Application) : AndroidViewModel(application) {

    private val repositoryApi: RepositoryApi = RepositoryApi()
    val response: MutableLiveData<Response<ApiModel>> = MutableLiveData()
    val response2: MutableLiveData<Response<ApiModel>> = MutableLiveData()


    fun getWeather() {
        viewModelScope.launch {
            response.value = repositoryApi.getWeather()
        }
    }

    fun getWeather2(
        city: String,
        numberCnt:Int,
        apiKey:String,
        language :String,
        unitsMetric: String
    ){
        viewModelScope.launch {
            response2.value = repositoryApi.getWeatherWithParam(city, numberCnt, apiKey, language, unitsMetric)
        }
    }


}