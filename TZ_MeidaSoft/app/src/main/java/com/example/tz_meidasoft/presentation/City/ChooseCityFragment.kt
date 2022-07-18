package com.example.tz_meidasoft.presentation.City

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tz_meidasoft.databinding.ChooseCityFragmentBinding
import com.example.tz_meidasoft.presentation.adapter.ChooseCityAdapter.AdapterChooseCity
import java.lang.RuntimeException

class ChooseCityFragment : Fragment() {

    private var _binding: ChooseCityFragmentBinding?= null
    private val binding : ChooseCityFragmentBinding
        get() = _binding ?: throw RuntimeException("")
    private lateinit var viewModel: ChooseCityViewModel

    private val cityList: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ChooseCityFragmentBinding.inflate(inflater, container, false)
        cityList.add("Москва")
        cityList.add("Ульяновск")
        cityList.add("Самара")
        setAdapter()


        binding.addCity.setOnClickListener {
            setAdapter()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ChooseCityViewModel::class.java)

        setAdapter()
    }

    private fun addCity() {

    }

    private fun setAdapter(){
        binding.cityWeatherAdapter.adapter = AdapterChooseCity(cityList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}