package com.example.tz_meidasoft.presentation.City

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.tz_meidasoft.R
import com.example.tz_meidasoft.data.entity.dbModel.City
import com.example.tz_meidasoft.databinding.ChooseCityFragmentBinding
import com.example.tz_meidasoft.domain.entity.CityDomain
import com.example.tz_meidasoft.presentation.adapter.Interface.ChooseCity
import com.example.tz_meidasoft.presentation.adapter.ChooseCityAdapter.AdapterChooseCity
import java.lang.RuntimeException

class ChooseCityFragment : Fragment() {

    private var _binding: ChooseCityFragmentBinding?= null
    private val binding : ChooseCityFragmentBinding
        get() = _binding ?: throw RuntimeException("ChooseCityFragmentBinding == null")

    private lateinit var viewModel: ChooseCityViewModel
    private val cityList: ArrayList<CityDomain> = ArrayList()

    override fun onResume() {
        getListCity()
        super.onResume()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ChooseCityFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ChooseCityViewModel::class.java]

        binding.addCity.setOnClickListener {
            addCity()
        }

        binding.chooseCity.setOnClickListener {
            getListCity()
        }

    }

    private fun addCity() {
        viewModel.insertCity(CityDomain(null, "Ульяновск", true))
        getListCity()
    }


    private fun deleteCity(cityDomain: CityDomain){
        cityDomain.id?.let { viewModel.deleteCity(it) }
        getListCity()
    }

    private fun getListCity(){
        viewModel.getListCity().observe(viewLifecycleOwner){
            cityList.clear()
            cityList.addAll(it)
            setAdapter()
        }
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