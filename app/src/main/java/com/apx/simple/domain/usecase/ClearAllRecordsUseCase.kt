package com.apx.simple.domain.usecase

import com.apx.simple.domain.repository.RecordRepository
import javax.inject.Inject

class ClearAllRecordsUseCase @Inject constructor(
    private val repository: RecordRepository
) {
    suspend operator fun invoke() {
        repository.clearAllRecords()
    }
}
