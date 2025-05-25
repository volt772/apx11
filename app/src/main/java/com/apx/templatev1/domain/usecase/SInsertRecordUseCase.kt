package com.apx.templatev1.domain.usecase

import com.apx.apx101.domain.model.SRecordModel
import com.apx.templatev1.domain.repository.SRecordRepository
import javax.inject.Inject

class SInsertRecordUseCase @Inject constructor(
    private val repository: SRecordRepository
) {
    suspend operator fun invoke(record: SRecordModel) {
        repository.insertRecord(record)
    }
}