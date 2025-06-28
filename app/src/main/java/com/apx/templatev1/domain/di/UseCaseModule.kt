package com.apx.templatev1.domain.di

import com.apx.templatev1.domain.repository.RecordRepository
import com.apx.templatev1.domain.usecase.ClearAllRecordsUseCase
import com.apx.templatev1.domain.usecase.GetAllRecordsUseCase
import com.apx.templatev1.domain.usecase.InsertRecordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

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