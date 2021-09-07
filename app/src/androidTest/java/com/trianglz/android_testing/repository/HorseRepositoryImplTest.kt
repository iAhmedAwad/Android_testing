package com.trianglz.android_testing.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.trianglz.android_testing.data.local.Horse
import com.trianglz.android_testing.data.model.HorseResponse
import com.trianglz.android_testing.data.model.HorseResponseItem
import com.trianglz.android_testing.data.repository.HorseRepository
import com.trianglz.common.Resource
import org.junit.Assert.*

class HorseRepositoryImplTest :HorseRepository{
    private val horses = mutableListOf<Horse>()

    private val horseResponseItems = mutableListOf<HorseResponseItem>()

    private val observableHorses = MutableLiveData<List<Horse>>(horses)

    private var shouldReturnError = false

    fun setShouldReturnError(shouldReturnError:Boolean){
        this.shouldReturnError = shouldReturnError
    }

    private fun refreshList(){
        observableHorses.postValue(horses)
    }

    override suspend fun addHorse(horse: Horse) {
      horses.add(horse)
        refreshList()
    }

    override suspend fun deleteHorse(horse: Horse) {
        horses.remove(horse)
        refreshList()
    }

    override fun getAllHorsesFromDB(): LiveData<List<Horse>> {
       return observableHorses
    }

    override suspend fun getAllHorses(): Resource<HorseResponse> {
        return if(shouldReturnError){
            Resource.error("Error", null)
        }else{
            Resource.success(HorseResponse(horseResponseItems))
        }
    }
}