package com.apx.simple.domain.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object UseCaseModule {

    /*추천방법*/
//    @Provides
//    @Singleton
//    fun providePlatformUseCases(
//        repository: PlatformRepository
//    ): PlatformUseCase {
//        return PlatformUseCase(
//            getAllPlatforms = GetAllPlatforms(repository),
//            insertAllPlatforms = InsertAllPlatforms(repository)
//        )
//    }
}