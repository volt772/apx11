package com.apx.templatev1.domain.repository

import com.apx.apx101.domain.model.SRecordModel
import kotlinx.coroutines.flow.Flow

interface SRecordRepository {

    suspend fun insertRecord(SRecordModel: SRecordModel)

    fun getAllRecords(): Flow<List<SRecordModel>>

    suspend fun clearAllRecords()

}