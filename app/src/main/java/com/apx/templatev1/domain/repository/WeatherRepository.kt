package com.apx.templatev1.domain.repository

import com.apx.templatev1.domain.dto.CurrentWeatherInfo
import com.apx.templatev1.domain.dto.ForecastWeatherInfo
import com.apx.templatev1.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun getCurrentWeatherInfo(
        lat: Double,
        lon: Double,
        appId: String
    ): Flow<Resource<CurrentWeatherInfo>>

    suspend fun getForecastWeatherInfo(
        lat: Double,
        lon: Double,
        appId: String
    ): Flow<Resource<ForecastWeatherInfo>>
}