package com.trianglz.android_testing.data.repository

import androidx.lifecycle.LiveData
import com.trianglz.android_testing.data.local.Horse
import com.trianglz.android_testing.data.model.HorseResponse
import com.trianglz.common.Resource

interface HorseRepository {

    suspend fun addHorse(horse: Horse)

    suspend fun deleteHorse(horse: Horse)

    fun getAllHorsesFromDB(): LiveData<List<Horse>>

    suspend fun getAllHorses(): Resource<HorseResponse>
}