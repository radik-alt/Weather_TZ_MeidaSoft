package com.example.tz_meidasoft.presentation.TodayWeather

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tz_meidasoft.data.entity.CityMapper
import com.example.tz_meidasoft.data.repository.CityRepositoryImpl
import com.example.tz_meidasoft.data.repository.RepositoryApiImpl
import com.example.tz_meidasoft.data.room.DatabaseCity
import com.example.tz_meidasoft.domain.entity.CityDomain
import com.example.tz_meidasoft.domain.entity.apiDomain.ApiDomain
import com.example.tz_meidasoft.domain.uescase.Api.GetApiDataCityName
import com.example.tz_meidasoft.domain.uescase.DB.GetByUsedCity
import kotlinx.coroutines.*
import retrofit2.Response

class WeatherViewModel(application: Application) : AndroidViewModel(application) {

    private val repositoryApiImpl: RepositoryApiImpl = RepositoryApiImpl()
    val responseApi: MutableLiveData<Response<ApiDomain>> = MutableLiveData()

    private val dao = DatabaseCity.getDatabaseCity(application).daoCity()
    private val mapper = CityMapper()
    private val repo = CityRepositoryImpl(dao, mapper)
    private val repoApi = RepositoryApiImpl()

    fun getUsedCity():LiveData<CityDomain>{
        return GetByUsedCity(repo).getByUsedCity()
    }

    fun getWeatherCity(city:String){
        viewModelScope.launch {
            responseApi.value = GetApiDataCityName(repoApi).getApiDataCityName(city)
        }
    }


}