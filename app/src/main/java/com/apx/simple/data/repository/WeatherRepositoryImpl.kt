package com.apx.simple.data.repository

import com.apx.simple.data.mappers.toCurrentWeatherInfo
import com.apx.simple.data.remote.WeatherApi
import com.apx.simple.di.DefaultDispatcher
import com.apx.simple.domain.dto.CurrentWeatherInfo
import com.apx.simple.domain.repository.WeatherRepository
import com.apx.simple.domain.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/* Network Sample*/
class WeatherRepositoryImpl @Inject constructor(
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,
    private val api: WeatherApi
): WeatherRepository {

    /**
     * FETCH
     */
    override suspend fun getCurrentWeatherInfo(
        lat: Double,
        lon: Double,
        appId: String
    ): Flow<Resource<CurrentWeatherInfo>> {
        return try {
            val currentWeatherInfo = api.getCurrentWeatherData(
                lat = lat,
                lon = lon,
                appId = appId
            ).toCurrentWeatherInfo()

            flowOf(Resource.Success(currentWeatherInfo))
        } catch (e: Exception) {
            flowOf(Resource.Failed(e.message?: "Error Occurred"))
        }
    }

}