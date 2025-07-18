package com.apx.simple.domain.repository

import com.apx.simple.domain.model.SampleModel
import kotlinx.coroutines.flow.Flow

interface SampleRepository {
    fun getAllPlatforms(): Flow<List<SampleModel>>
    suspend fun insertAll(platforms: List<SampleModel>)
}