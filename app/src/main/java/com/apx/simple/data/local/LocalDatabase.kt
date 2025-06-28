package com.apx.simple.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.apx.simple.data.local.converter.RecordConverter
import com.apx.simple.data.local.dao.RecordDao
import com.apx.simple.data.local.entity.Record

@Database(
    entities = [Record::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(RecordConverter::class)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun recordDao(): RecordDao
}