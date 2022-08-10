package com.example.tz_meidasoft.data.entity.apiModel

data class ApiModel(
    val city: City,
    val cod: String,
    val message: Double,
    val cnt: Int,
    val list: List<Lists>,
)