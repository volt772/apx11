package com.apx.simple.data.mappers


import com.apx.simple.data.local.entity.Sample
import com.apx.simple.domain.model.SampleModel

fun Sample.toModel(): SampleModel =
    SampleModel(id = id, name = name, iconResName = iconResName)

fun SampleModel.toEntity(): Sample =
    Sample(id = id, name = name, iconResName = iconResName)