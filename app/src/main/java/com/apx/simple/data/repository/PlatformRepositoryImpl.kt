package com.apx.simple.data.repository

import com.apx.simple.data.local.dao.SampleDao
import com.apx.simple.data.mappers.toEntity
import com.apx.simple.data.mappers.toModel
import com.apx.simple.domain.model.SampleModel
import com.apx.simple.domain.repository.SampleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(
    private val dao: SampleDao
) : SampleRepository {
    override fun getAllPlatforms(): Flow<List<SampleModel>> =
        dao.getAllPlatforms().map { list -> list.map { it.toModel() } }

    override suspend fun insertAll(platforms: List<SampleModel>) {
        dao.insertAll(platforms.map { it.toEntity() })
    }
}
