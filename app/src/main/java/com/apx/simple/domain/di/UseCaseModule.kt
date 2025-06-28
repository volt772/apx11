package com.apx.simple.domain.di

import com.apx.simple.domain.repository.RecordRepository
import com.apx.simple.domain.usecase.ClearAllRecordsUseCase
import com.apx.simple.domain.usecase.GetAllRecordsUseCase
import com.apx.simple.domain.usecase.InsertRecordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object UseCaseModule {

    /*추천방법*/
//    @Provides
//    @Singleton
//    fun provideIdeaUseCases(
//        repository: IdeaRepository
//    ): IdeaUseCases {
//        return IdeaUseCases(
//            addIdea = AddIdea(repository),
//            deleteIdea = DeleteIdea(repository),
//            getIdeas = GetIdeas(repository),
//            searchIdeas = SearchIdeas(repository)
//        )
//    }

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