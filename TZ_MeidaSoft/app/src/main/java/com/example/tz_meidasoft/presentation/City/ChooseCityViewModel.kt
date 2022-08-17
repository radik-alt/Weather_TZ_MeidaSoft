package com.example.tz_meidasoft.presentation.City

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.tz_meidasoft.data.entity.CityMapper
import com.example.tz_meidasoft.data.repository.CityRepositoryImpl
import com.example.tz_meidasoft.data.room.DatabaseCity
import com.example.tz_meidasoft.domain.entity.CityDomain
import com.example.tz_meidasoft.domain.uescase.DB.DeleteCity
import com.example.tz_meidasoft.domain.uescase.DB.GetListCity
import com.example.tz_meidasoft.domain.uescase.DB.InsertCity
import com.example.tz_meidasoft.domain.uescase.DB.UpdateCity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChooseCityViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = DatabaseCity.getDatabaseCity(application).daoCity()
    private val mapper = CityMapper()
    private val repository = CityRepositoryImpl(dao, mapper)

    fun getListCity():LiveData<List<CityDomain>>{
        return GetListCity(repository).getListCity()
    }

    fun deleteCity(id:Long){
        DeleteCity(repository).deleteCity(id)
    }

    fun updateCity(city:CityDomain){
        UpdateCity(repository).updateCity(city)
    }

    fun setOtherCityNotUsed(){
        repository.setOtherCityNotUsed()
    }

    fun insertCity(city:CityDomain){
        CoroutineScope(Dispatchers.Default).launch {
            InsertCity(repository).insertCity(city)
        }
    }
}