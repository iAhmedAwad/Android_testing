package com.trianglz.android_testing.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Horse::class], version = 1)
abstract class HorsesDatabase : RoomDatabase() {
    abstract fun horseDao():HorseDao
}