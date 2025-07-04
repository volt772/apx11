package com.apx.simple.data.remote

import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String,
        @Query("units") units: String?= "metric",
        @Query("lang") lang: String?= "kr",
    ): CurrentResponseDto

    @GET("data/2.5/forecast")
    suspend fun getForecastWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String,
        @Query("units") units: String?= "metric",
        @Query("lang") lang: String?= "kr",
    ): ForecastResponseDto
}