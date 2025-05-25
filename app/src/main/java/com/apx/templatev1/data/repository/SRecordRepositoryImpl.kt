package com.apx.templatev1.data.repository

import com.apx.apx101.data.local.dao.RecordDao
import com.apx.apx101.data.mappers.toEntity
import com.apx.apx101.data.mappers.toModel
import com.apx.apx101.domain.model.SRecordModel
import com.apx.apx101.domain.repository.RecordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.collections.map


class SRecordRepositoryImpl @Inject constructor(
    private val dao: RecordDao
): RecordRepository {

    override suspend fun insertRecord(SRecordModel: SRecordModel) {
        dao.insert(SRecordModel.toEntity())
    }

    override fun getAllRecords(): Flow<List<SRecordModel>> {
        return dao.getAll().map { list -> list.map { it.toModel() } }
    }

    override suspend fun clearAllRecords() {
        dao.clearAll()
    }

}

