package com.apx.simple.data.mappers

import com.apx.simple.data.local.entity.Record
import com.apx.simple.domain.model.RecordModel
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

fun RecordModel.toEntity(): Record {
    val resultJson = Gson().toJson(resultList)
    return Record(
        id = id,
        totalAmount = totalAmount,
        peopleCount = peopleCount,
        roundingPolicy = roundingPolicy,
        roundingUnit = roundingUnit,
        resultJson = resultJson,
        createdAt = createdAt
    )
}

fun Record.toModel(): RecordModel {
    val resultList: List<Int> = Gson().fromJson(
        resultJson,
        object : TypeToken<List<Int>>() {}.type
    )
    return RecordModel(
        id = id,
        totalAmount = totalAmount,
        peopleCount = peopleCount,
        roundingPolicy = roundingPolicy,
        roundingUnit = roundingUnit,
        resultList = resultList,
        createdAt = createdAt
    )
}