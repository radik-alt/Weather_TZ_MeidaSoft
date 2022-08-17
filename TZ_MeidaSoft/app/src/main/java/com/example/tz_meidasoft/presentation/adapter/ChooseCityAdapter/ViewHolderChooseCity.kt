package com.example.tz_meidasoft.presentation.adapter.ChooseCityAdapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tz_meidasoft.R

class ViewHolderChooseCity(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val city = itemView.findViewById<TextView>(R.id.city_name_list)

}