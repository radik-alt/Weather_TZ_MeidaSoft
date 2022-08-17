package com.example.tz_meidasoft.presentation.adapter.ChooseCityAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tz_meidasoft.R
import com.example.tz_meidasoft.domain.entity.CityDomain
import com.example.tz_meidasoft.presentation.adapter.Interface.ChooseCity

class AdapterChooseCity(
    private val list: List<CityDomain>,
    private val chooseCity: ChooseCity
) : RecyclerView.Adapter<ViewHolderChooseCity>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderChooseCity {
        val layout = when(viewType){
            ACTIVITY -> R.layout.list_choose_city_activity
            else -> R.layout.list_choose_city
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolderChooseCity(view)
    }

    override fun onBindViewHolder(holder: ViewHolderChooseCity, position: Int) {
        holder.city.text = list[position].city

        holder.itemView.setOnClickListener {
            chooseCity.selectCity(list[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(list[position].used){
            ACTIVITY
        } else{
          NO_ACTIVITY
        }
    }

    override fun getItemCount(): Int = list.size


    companion object{
        private const val ACTIVITY = 1
        private const val NO_ACTIVITY = 0
    }
}