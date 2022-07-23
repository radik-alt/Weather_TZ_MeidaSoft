package com.example.tz_meidasoft.presentation.adapter.ChooseCityAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.tz_meidasoft.R
import com.example.tz_meidasoft.data.room.City
import com.example.tz_meidasoft.presentation.Interface.ChooseCity

class AdapterChooseCity(val list: ArrayList<City>, val chooseCity: ChooseCity) : RecyclerView.Adapter<ViewHolderChooseCity>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderChooseCity {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_choose_city, parent, false)
        return ViewHolderChooseCity(view)
    }

    override fun onBindViewHolder(holder: ViewHolderChooseCity, position: Int) {
        holder.city.text = list[position].city

        holder.itemView.setOnClickListener {
            chooseCity.selectCity(list[position].city)
        }
    }

    override fun getItemCount(): Int = list.size
}