package com.example.tz_meidasoft.data.entity.apiModel

data class Lists(
    val dt: Int,
    val sunrise: Int,
    val sunset: Int,
    val temp: Temp,
    val feels_like: FeelsLike,
    val pressure: Int,
    val humidity: Int,
    val weather: List<Weather>,
    val speed: Double,
    val deg: Int,
    val gust: Double,
    val clouds: Int,
    val pop: Double,
    val rain: Double?
)