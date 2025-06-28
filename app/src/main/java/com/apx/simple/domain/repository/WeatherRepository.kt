package com.apx.simple.domain.repository

import com.apx.simple.domain.dto.CurrentWeatherInfo
import com.apx.simple.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun getCurrentWeatherInfo(
        lat: Double,
        lon: Double,
        appId: String
    ): Flow<Resource<CurrentWeatherInfo>>
}