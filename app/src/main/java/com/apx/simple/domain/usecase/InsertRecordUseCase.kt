package com.apx.simple.domain.usecase

import com.apx.simple.domain.model.RecordModel
import com.apx.simple.domain.repository.RecordRepository
import javax.inject.Inject

class InsertRecordUseCase @Inject constructor(
    private val repository: RecordRepository
) {
    suspend operator fun invoke(record: RecordModel) {
        repository.insertRecord(record)
    }
}