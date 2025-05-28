package com.apx.templatev1.domain.usecase

import com.apx.templatev1.domain.model.RecordModel
import com.apx.templatev1.domain.repository.RecordRepository
import javax.inject.Inject

class InsertRecordUseCase @Inject constructor(
    private val repository: RecordRepository
) {
    suspend operator fun invoke(record: RecordModel) {
        repository.insertRecord(record)
    }
}