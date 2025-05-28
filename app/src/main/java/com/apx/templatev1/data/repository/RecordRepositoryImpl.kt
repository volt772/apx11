package com.apx.templatev1.data.repository

import com.apx.templatev1.data.local.dao.RecordDao
import com.apx.templatev1.data.mappers.toEntity
import com.apx.templatev1.data.mappers.toModel
import com.apx.templatev1.domain.model.RecordModel
import com.apx.templatev1.domain.repository.RecordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class RecordRepositoryImpl @Inject constructor(
    private val dao: RecordDao
): RecordRepository {

    override suspend fun insertRecord(recordModel: RecordModel) {
        dao.insert(recordModel.toEntity())
    }

    override fun getAllRecords(): Flow<List<RecordModel>> {
        return dao.getAll().map { list -> list.map { it.toModel() } }
    }

    override suspend fun clearAllRecords() {
        dao.clearAll()
    }

}

