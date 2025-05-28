package com.apx.templatev1.domain.usecase

import com.apx.templatev1.domain.repository.RecordRepository
import javax.inject.Inject

class ClearAllRecordsUseCase @Inject constructor(
    private val repository: RecordRepository
) {
    suspend operator fun invoke() {
        repository.clearAllRecords()
    }
}
