package com.apx.templatev1.domain.di

import com.apx.templatev1.domain.repository.RecordRepository
import com.apx.templatev1.domain.usecase.ClearAllRecordsUseCase
import com.apx.templatev1.domain.usecase.GetAllRecordsUseCase
import com.apx.templatev1.domain.usecase.InsertRecordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object UseCaseModule {

    @Provides
    fun provideInsertRecordUseCase(
        recordRepository: RecordRepository
    ) = InsertRecordUseCase(recordRepository)

    fun provideGetAllRecordsUseCase(
        recordRepository: RecordRepository
    ) = GetAllRecordsUseCase(recordRepository)

    fun provideClearAllRecordsUseCase(
        recordRepository: RecordRepository
    ) = ClearAllRecordsUseCase(recordRepository)
}