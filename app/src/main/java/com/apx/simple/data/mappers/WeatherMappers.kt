package com.apx.simple.data.mappers

import com.apx.simple.data.remote.CurrentResponseDto
import com.apx.simple.data.remote.ForecastResponseDto
import com.apx.simple.data.util.convertUTCtoLocalFormat
import com.apx.simple.domain.constants.TranslatedDescription
import com.apx.simple.domain.dto.CurrentWeatherInfo
import com.apx.simple.domain.dto.ForecastListInfo
import com.apx.simple.domain.dto.ForecastWeatherInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlin.collections.first
import kotlin.collections.last
import kotlin.collections.map
import kotlin.math.roundToInt
import kotlin.text.split
import kotlin.to


const val weatherIconBaseURL = "https://openweathermap.org/img/wn"

/**
 * 데이터 변환 [CurrentResponseDto] to [CurrentWeatherInfo]
 */
fun CurrentResponseDto.toCurrentWeatherInfo(): CurrentWeatherInfo {
    return if (this.weatherData.isEmpty()) {
        CurrentWeatherInfo()
    } else {
        val weatherData = this.weatherData.first()
        CurrentWeatherInfo(
            weatherId = weatherData.id,
            weatherMain = weatherData.main,
            weatherDescription = getWeatherTranslatedDescription(weatherData.id, weatherData.description),
            temp = this.main.temp.roundToInt(),
            humidity = this.main.humidity,
            feelsLike = this.main.feelsLike.roundToInt(),
            weatherIcon = "$weatherIconBaseURL/${weatherData.icon}.png",
            cityName = this.name,
            cod = this.cod
        )
    }
}

/**
 * 데이터 변환 [ForecastResponseDto] to [ForecastWeatherInfo]
 *
 * @Desc 시간변환 문제
 * UTC 시간을 Local시간으로 변환하여 제공한다 (+9시간)
 * ForecastListInfo내에는 일자와 시간을 분리하여 저장한다
 */
suspend fun ForecastResponseDto.toForecastWeatherInfo(
    defaultDispatcher: CoroutineDispatcher
): ForecastWeatherInfo {
    val forecastDto = this
    return withContext(defaultDispatcher) {
        val forecast = forecastDto.list.map { fd ->
            val weatherData = fd.weather.first()

            /* UTC to Local*/
            val localDateTime = fd.dt * 1000
            val localDtTxt = localDateTime.convertUTCtoLocalFormat()

            /**
             * Split `Date` and `Time`
             * @Date : '2020-01-01'
             * @Time : '15:00:00'
             */
            val localDtTxtArr = localDtTxt.split(" ")
            val (localDtTxtDate, localDtTxtTime) = localDtTxtArr.first() to localDtTxtArr.last()

            ForecastListInfo(
                dt = localDateTime,
                temp = fd.main.temp.roundToInt(),
                dtTxtDate = localDtTxtDate,
                dtTxtTime = localDtTxtTime,
                weatherId = weatherData.id,
                weatherDescription = getWeatherTranslatedDescription(weatherData.id, weatherData.description),
                weatherMain = weatherData.main,
                weatherIcon = "$weatherIconBaseURL/${weatherData.icon}.png",
            )
        }

        ForecastWeatherInfo(
            forecastList = forecast
        )
    }
}

/**
 * Weather Description
 * @param weatherId 날씨ID
 * @param orgDescription 원본설명 (API에서 내려주는 원본값, 예) 실비. 튼구름.. 등)
 */
private fun getWeatherTranslatedDescription(
    weatherId: Int,
    orgDescription: String
): String {
    val weatherDescription = TranslatedDescription.from(weatherId)

    return if (weatherDescription == TranslatedDescription.NAN)
        orgDescription
    else
        weatherDescription.desc
}