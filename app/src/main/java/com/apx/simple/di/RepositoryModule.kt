package com.apx.simple.di

import com.apx.simple.data.repository.RecordRepositoryImpl
import com.apx.simple.data.repository.WeatherRepositoryImpl
import com.apx.simple.domain.repository.RecordRepository
import com.apx.simple.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository

    @Binds
    @Singleton
    abstract fun bindRecordRepository(recordRepository: RecordRepositoryImpl): RecordRepository
}