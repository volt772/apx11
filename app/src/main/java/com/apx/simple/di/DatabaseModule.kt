package com.apx.simple.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.apx.simple.data.local.LocalDatabase
import com.apx.simple.data.local.dao.SampleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext appContext: Context,
    ): LocalDatabase =
        Room.databaseBuilder(
            appContext,
            LocalDatabase::class.java,
            "sample.db"
        )
        .addMigrations(MIGRATION_1_TO_2)
        .build()

    @Provides
    @Singleton
    fun provideRecordDao(database: LocalDatabase): SampleDao =
        database.sampleDao()
}

val MIGRATION_1_TO_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("ALTER TABLE record ADD COLUMN memo TEXT DEFAULT '' NOT NULL")
    }
}