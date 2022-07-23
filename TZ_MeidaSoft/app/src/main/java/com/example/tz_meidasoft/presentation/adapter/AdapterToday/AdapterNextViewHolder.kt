package com.example.tz_meidasoft.presentation.adapter.AdapterToday

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tz_meidasoft.R

class AdapterNextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val image = itemView.findViewById<ImageView>(R.id.imageWeatherNext)
    val day = itemView.findViewById<TextView>(R.id.dayNext)
    val descriptionWeather = itemView.findViewById<TextView>(R.id.descriptionWeatherNext)
    val maxDegree = itemView.findViewById<TextView>(R.id.maxDegreeNext)
    val minDegree = itemView.findViewById<TextView>(R.id.minDegreeNext)

}