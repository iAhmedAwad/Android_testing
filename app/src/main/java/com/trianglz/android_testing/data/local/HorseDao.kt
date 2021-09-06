package com.trianglz.android_testing.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HorseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHorse(horse: Horse)

    @Delete
    suspend fun deleteHorse(horse: Horse)

    @Query("SELECT * FROM horses")
    fun getAllHorses(): LiveData<List<Horse>>
}