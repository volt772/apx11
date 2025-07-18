package com.apx.simple.domain.usecase

import com.apx.simple.domain.model.SampleModel
import com.apx.simple.domain.repository.SampleRepository
import kotlinx.coroutines.flow.Flow

data class SampleUseCase(
    val getAllPlatforms: GetAllPlatforms,
    val insertAllPlatforms: InsertAllPlatforms
) {
    class GetAllPlatforms(
        private val repository: SampleRepository
    ) {
        operator fun invoke(): Flow<List<SampleModel>> =
            repository.getAllPlatforms()
    }

    class InsertAllPlatforms(
        private val repository: SampleRepository
    ) {
        suspend operator fun invoke(platforms: List<SampleModel>) =
            repository.insertAll(platforms)
    }
}