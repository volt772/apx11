package com.apx.apx101.domain.model

data class SRecordModel(
    val id: Int = 0,
    val totalAmount: Int,
    val peopleCount: Int,
    val roundingPolicy: String,
    val roundingUnit: Int,
    val resultList: List<Int>,
    val createdAt: Long = System.currentTimeMillis()
)