package com.apx.simple.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sample")
data class Sample(
    @PrimaryKey val id: Long,
    val name: String,
    val iconResName: String
)
