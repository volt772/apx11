package com.apx.templatev1.domain.usecase

import com.apx.templatev1.domain.repository.SRecordRepository
import javax.inject.Inject

class SClearAllRecordsUseCase @Inject constructor(
    private val repository: SRecordRepository
) {
    suspend operator fun invoke() {
        repository.clearAllRecords()
    }
}
