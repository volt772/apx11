package com.apx.simple.data.remote

import com.squareup.moshi.Json

data class WeatherMainDto(
    @field:Json(name = "temp")
    val temp: Double,

    @field:Json(name = "feels_like")
    val feelsLike: Double,

    @field:Json(name = "humidity")
    val humidity: Int,

    @field:Json(name = "temp_min")
    val tempMin: Double,

    @field:Json(name = "temp_max")
    val tempMax: Double
)