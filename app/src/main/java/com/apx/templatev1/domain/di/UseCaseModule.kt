package com.apx.templatev1.domain.di

import com.apx.templatev1.domain.repository.SRecordRepository
import com.apx.templatev1.domain.usecase.SClearAllRecordsUseCase
import com.apx.templatev1.domain.usecase.SGetAllRecordsUseCase
import com.apx.templatev1.domain.usecase.SInsertRecordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object UseCaseModule {

    @Provides
    fun provideInsertRecordUseCase(
        recordRepository: SRecordRepository
    ) = SInsertRecordUseCase(recordRepository)

    fun provideGetAllRecordsUseCase(
        recordRepository: SRecordRepository
    ) = SGetAllRecordsUseCase(recordRepository)

    fun provideClearAllRecordsUseCase(
        recordRepository: SRecordRepository
    ) = SClearAllRecordsUseCase(recordRepository)
}