package com.jezdevcode.hymnairelldm.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Hymn::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    
    abstract fun hymnDao(): HymnDao   
}
