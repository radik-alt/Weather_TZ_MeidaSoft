package com.example.tz_meidasoft.presentation.City

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChooseCityViewModel : ViewModel() {

    private val chooseCity: LiveData<String> = MutableLiveData<String>()
    private val cityList = ArrayList<String>()
    private val cityListLiveData : LiveData<ArrayList<String>> = MutableLiveData<ArrayList<String>>()

    public fun getCity() : LiveData<String>{
        return chooseCity
    }

    public fun getListCity() : LiveData<ArrayList<String>>{
        return cityListLiveData
    }

    public fun addCity(city: String) {
        cityList.add("Москва")
        cityListLiveData.value?.addAll(cityList)
    }
}