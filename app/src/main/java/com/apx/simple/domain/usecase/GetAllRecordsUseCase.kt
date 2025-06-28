package com.apx.simple.domain.usecase

import com.apx.simple.domain.model.RecordModel
import com.apx.simple.domain.repository.RecordRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllRecordsUseCase @Inject constructor(
    private val repository: RecordRepository
) {

    operator fun invoke(): Flow<List<RecordModel>> = repository.getAllRecords()

}