package com.apx.templatev1.domain.repository

import com.apx.templatev1.domain.model.RecordModel
import kotlinx.coroutines.flow.Flow

interface RecordRepository {

    suspend fun insertRecord(recordModel: RecordModel)

    fun getAllRecords(): Flow<List<RecordModel>>

    suspend fun clearAllRecords()

}