package com.apx.templatev1.domain.usecase

import com.apx.templatev1.domain.model.RecordModel
import com.apx.templatev1.domain.repository.RecordRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllRecordsUseCase @Inject constructor(
    private val repository: RecordRepository
) {

    operator fun invoke(): Flow<List<RecordModel>> = repository.getAllRecords()

}