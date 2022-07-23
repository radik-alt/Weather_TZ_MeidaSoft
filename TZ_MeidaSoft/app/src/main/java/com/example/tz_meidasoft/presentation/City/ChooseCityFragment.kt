package com.example.tz_meidasoft.presentation.City

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.tz_meidasoft.R
import com.example.tz_meidasoft.data.room.City
import com.example.tz_meidasoft.databinding.ChooseCityFragmentBinding
import com.example.tz_meidasoft.presentation.Interface.ChooseCity
import com.example.tz_meidasoft.presentation.adapter.ChooseCityAdapter.AdapterChooseCity
import java.lang.RuntimeException

class ChooseCityFragment : Fragment() {

    private var _binding: ChooseCityFragmentBinding?= null
    private val binding : ChooseCityFragmentBinding
        get() = _binding ?: throw RuntimeException("")
    private lateinit var viewModel: ChooseCityViewModel

    private val cityList: ArrayList<City> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ChooseCityFragmentBinding.inflate(inflater, container, false)
        cityList.add(City(0, "Москва", false))
        cityList.add(City(1, "Ульяновск", true))
        cityList.add(City(2, "Самара", false))
        setAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ChooseCityViewModel::class.java]

        binding.addCity.setOnClickListener {
            addCity()
        }

        setAdapter()
    }

    private fun addCity() {

    }

    private fun setAdapter(){
        binding.cityWeatherAdapter.adapter = AdapterChooseCity(cityList, object : ChooseCity {
            override fun selectCity(city: String) {
                Navigation.findNavController(requireView()).navigate(R.id.action_chooseCityFragment_to_todayWeatherFragment)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}