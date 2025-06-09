package com.apx.templatev1.domain.constants

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.apx.templatev1.R
import com.apx.templatev1.presentation.ui.theme.AxBlue100

sealed class WeatherType(
    val code: Int,
    @DrawableRes val mainRes: Int,
    @DrawableRes val subRes: Int,
    @ColorRes val color: Color
) {

    /* 200 ThunderStorm*/
    data object Thunderstorm: WeatherType(
        code = 2,
        mainRes = R.drawable.ic_drizzle,
        subRes = R.drawable.ic_drizzle,
        color = AxBlue100
    )

    /* 300 Drizzle*/
    data object Drizzle : WeatherType(
        code = 3,
        mainRes = R.drawable.ic_drizzle,
        subRes = R.drawable.ic_drizzle,
        color = AxBlue100
    )

    /* 500 Rain*/
    data object Rain : WeatherType(
        code = 5,
        mainRes = R.drawable.ic_drizzle,
        subRes = R.drawable.ic_drizzle,
        color = AxBlue100
    )

    /* 600 Snow*/
    data object Snow: WeatherType(
        code = 6,
        mainRes = R.drawable.ic_drizzle,
        subRes = R.drawable.ic_drizzle,
        color = AxBlue100
    )

    /* 700 Atmosphere*/
    data object Atmosphere: WeatherType(
        code = 7,
        mainRes = R.drawable.ic_cloudy,
        subRes = R.drawable.ic_drizzle,
        color = AxBlue100
    )

    /* 800 Clear*/
    data object Clear: WeatherType(
        code = 8,
        mainRes = R.drawable.ic_drizzle,
        subRes = R.drawable.ic_drizzle,
        color = AxBlue100
    )

    /* 800 Clouds*/
    data object Clouds : WeatherType(
        code = 80,
        mainRes = R.drawable.ic_cloudy,
        subRes = R.drawable.ic_drizzle,
        color = AxBlue100
    )

    companion object {
        fun from(code: Int): WeatherType {
            return when(code) {
                Thunderstorm.code -> Thunderstorm
                Drizzle.code -> Drizzle
                Rain.code -> Rain
                Snow.code -> Snow
                Atmosphere.code -> Atmosphere
                Clear.code -> Clear
                Clouds.code -> Clouds
                else -> Clear
            }
        }
    }
}