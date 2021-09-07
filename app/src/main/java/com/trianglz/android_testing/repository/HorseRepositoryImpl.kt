package com.trianglz.android_testing.repository

import androidx.lifecycle.LiveData
import com.trianglz.android_testing.data.HorseService
import com.trianglz.android_testing.data.local.Horse
import com.trianglz.android_testing.data.local.HorseDao
import com.trianglz.android_testing.data.model.HorseResponse
import com.trianglz.android_testing.data.repository.HorseRepository
import com.trianglz.common.Resource
import javax.inject.Inject

class HorseRepositoryImpl @Inject constructor(
    private val dao: HorseDao,
    private val service: HorseService
) : HorseRepository {
    override suspend fun addHorse(horse: Horse) {
        dao.addHorse(horse)
    }

    override suspend fun deleteHorse(horse: Horse) {
        dao.deleteHorse(horse)
    }

    override fun getAllHorsesFromDB(): LiveData<List<Horse>> {
        return dao.getAllHorses()
    }

    override suspend fun getAllHorses(): Resource<HorseResponse> {

        return  try {
            val response = service.getHorses()
            if(response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                }?: Resource.error("An unknown error occurred", null)
            }else{
                Resource.error("An unknown error occurred", null)
            }
        }catch (e:Exception){
            Resource.error("Couldn't reach server", null)
        }
    }
}