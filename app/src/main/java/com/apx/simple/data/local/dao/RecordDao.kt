package com.apx.simple.data.local.dao

import androidx.room.*
import com.apx.simple.data.local.entity.Record
import kotlinx.coroutines.flow.Flow

@Dao
interface RecordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(record: Record)

    @Query("SELECT * FROM record ORDER BY createdAt DESC")
    fun getAll(): Flow<List<Record>>

    @Delete
    suspend fun delete(record: Record)

    @Query("DELETE FROM record")
    suspend fun clearAll()
}