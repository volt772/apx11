package com.apx.simple.di

import com.apx.simple.data.repository.SampleRepositoryImpl
import com.apx.simple.domain.repository.SampleRepository
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
    abstract fun bindSampleRepository(sampleRepository: SampleRepositoryImpl): SampleRepository
}