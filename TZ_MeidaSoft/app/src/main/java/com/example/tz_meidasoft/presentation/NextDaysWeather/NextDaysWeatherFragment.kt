package com.example.tz_meidasoft.presentation.NextDaysWeather

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tz_meidasoft.R

class NextDaysWeatherFragment : Fragment() {


    private lateinit var viewModel: NextDaysWeatherViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.next_days_weather_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(NextDaysWeatherViewModel::class.java)

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}