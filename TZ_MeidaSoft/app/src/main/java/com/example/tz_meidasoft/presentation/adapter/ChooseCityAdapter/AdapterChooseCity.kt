package com.example.tz_meidasoft.presentation.adapter.ChooseCityAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.tz_meidasoft.R

class AdapterChooseCity(val list: ArrayList<String>) : RecyclerView.Adapter<ViewHolderChooseCity>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderChooseCity {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_choose_city, parent, false)
        return ViewHolderChooseCity(view)
    }

    override fun onBindViewHolder(holder: ViewHolderChooseCity, position: Int) {
        holder.city.text = list[position]

        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_chooseCityFragment_to_todayWeatherFragment)
        }
    }

    override fun getItemCount(): Int = list.size
}