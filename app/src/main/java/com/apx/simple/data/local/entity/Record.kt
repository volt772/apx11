package com.apx.simple.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "record")
data class Record(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val totalAmount: Int,
    val peopleCount: Int,
    val roundingPolicy: String,
    val roundingUnit: Int,
    val resultJson: String,
    val createdAt: Long = System.currentTimeMillis()
)