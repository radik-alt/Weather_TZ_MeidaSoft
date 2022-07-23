package com.example.tz_meidasoft.presentation.City

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tz_meidasoft.data.entity.City
import com.example.tz_meidasoft.data.room.CityRepository
import com.example.tz_meidasoft.data.room.DatabaseCity

class ChooseCityViewModel(application: Application) : AndroidViewModel(application) {

    private val chooseCity: LiveData<String> = MutableLiveData<String>()
    private val cityList = ArrayList<String>()
    private val cityListLiveData : LiveData<ArrayList<City>> = MutableLiveData<ArrayList<City>>()

    private val repository: CityRepository

    init {
        val dao = DatabaseCity.getDatabaseCity(application).daoCity()
        repository = CityRepository(dao)
    }

//    public fun getListCity() : LiveData<ArrayList<String>>{
//        repository.getAllCity()
//    }

//    public fun addCity(city: String) {
//        cityList.add("Москва")
//        cityListLiveData.value?.addAll(cityList)
//    }
}