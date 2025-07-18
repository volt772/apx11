package com.apx.simple.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.apx.simple.data.local.converter.RecordConverter
import com.apx.simple.data.local.dao.SampleDao
import com.apx.simple.data.local.entity.Sample

@Database(
    entities = [
        Sample::class
   ],
    version = 1,
    exportSchema = false
)
@TypeConverters(RecordConverter::class)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun sampleDao(): SampleDao
}