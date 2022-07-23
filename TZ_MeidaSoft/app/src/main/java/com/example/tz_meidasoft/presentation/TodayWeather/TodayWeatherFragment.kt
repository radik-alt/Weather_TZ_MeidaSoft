package com.example.tz_meidasoft.presentation.TodayWeather

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tz_meidasoft.R
import com.example.tz_meidasoft.databinding.FragmentTodayWeatherBinding
import com.example.tz_meidasoft.presentation.adapter.AdapterToday.AdapterTodayNextDays
import java.lang.RuntimeException


class TodayWeatherFragment : Fragment() {

    private var _binding: FragmentTodayWeatherBinding? = null
    private val binding : FragmentTodayWeatherBinding
        get() = _binding ?: throw RuntimeException("FragmentTodayWeatherBinding == null")

    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodayWeatherBinding.inflate(layoutInflater, container, false)
        weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]

        if (isConnect()){
            getDataWeatherWithParam()
            setAdapter()
        } else {
            val dialog = DialogConnect()
            dialog.show(childFragmentManager, "customConnectDialog")
        }

        binding.forecast.setOnClickListener {
            findNavController().navigate(R.id.action_todayWeatherFragment_to_nextDaysWeatherFragment)
        }

        return binding.root
    }

    private fun getDataWeatherWithParam(){
        weatherViewModel.getWeather2(
            "Ульяновск",
            1,
            "87dcdc26b0bccc33955d2e4e2cf87795",
            "ru",
            "metric"
        )
        weatherViewModel.response2.observe(viewLifecycleOwner){
            if (it.isSuccessful){
                Log.d("ResponseWeather", it.body().toString())
            }
        }

    }

    private fun setDataWeather() {

        weatherViewModel.getWeather()
        weatherViewModel.response.observe(viewLifecycleOwner) { it ->
            val response = it.body()
            try {
                binding.nameCity.text = response?.city?.name
                binding.degreeWeather.text = Math.round(response?.list?.get(0)?.temp?.day!!).toString()
//            binding.sunset.text = response?.list?.get(0)?.sunset.toString()
//            binding.sunrise.text = response?.list?.get(0)?.sunrise.toString()
                binding.humidity.text = response.list.get(0).humidity.toString()
                binding.pressure.text = response.list.get(0).pressure.toString()
                binding.speedWind.text = response.list.get(0).speed.toString()
            } catch (e: Exception){

            }
        }
    }

    private fun setAdapter() {
        val list = ArrayList<String>()
        list.add("Сегодня")
        list.add("Завтра")
        list.add("Послезватра")
        binding.nextDaysRecycler.adapter = AdapterTodayNextDays(list)
    }

    private fun isConnect () : Boolean {
        val connectManager = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activityNetwork: NetworkInfo? = connectManager.activeNetworkInfo
        val isConnect = activityNetwork?.isConnectedOrConnecting

        if (isConnect == true) {
            return true
        }
        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}