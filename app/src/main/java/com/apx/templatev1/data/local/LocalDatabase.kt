package com.apx.templatev1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.apx.templatev1.data.local.converter.RecordConverter
import com.apx.templatev1.data.local.dao.RecordDao
import com.apx.templatev1.data.local.entity.Record

@Database(
    entities = [Record::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(RecordConverter::class)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun recordDao(): RecordDao
}