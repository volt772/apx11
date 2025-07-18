package com.apx.simple.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apx.simple.data.local.entity.Sample
import kotlinx.coroutines.flow.Flow

@Dao
interface SampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(platforms: List<Sample>)

    @Query("SELECT * FROM sample ORDER BY name ASC")
    fun getAllPlatforms(): Flow<List<Sample>>

}