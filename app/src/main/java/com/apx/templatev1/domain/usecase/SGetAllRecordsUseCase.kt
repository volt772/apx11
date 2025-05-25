package com.apx.templatev1.domain.usecase

import com.apx.apx101.domain.model.SRecordModel
import com.apx.templatev1.domain.repository.SRecordRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SGetAllRecordsUseCase @Inject constructor(
    private val repository: SRecordRepository
) {

    operator fun invoke(): Flow<List<SRecordModel>> = repository.getAllRecords()

}