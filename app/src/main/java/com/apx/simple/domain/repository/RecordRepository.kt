package com.apx.simple.domain.repository

import com.apx.simple.domain.model.RecordModel
import kotlinx.coroutines.flow.Flow

interface RecordRepository {

    suspend fun insertRecord(recordModel: RecordModel)

    fun getAllRecords(): Flow<List<RecordModel>>

    suspend fun clearAllRecords()

}