package com.apx.templatev1.domain.model

data class RecordModel(
    val id: Int = 0,
    val totalAmount: Int,
    val peopleCount: Int,
    val roundingPolicy: String,
    val roundingUnit: Int,
    val resultList: List<Int>,
    val createdAt: Long = System.currentTimeMillis()
)