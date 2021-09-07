package com.trianglz.android_testing.data

import com.haroldadmin.cnradapter.NetworkResponse
import com.trianglz.android_testing.data.model.HorseResponse
import com.trianglz.common.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HorseService {

    @GET(Constants.POSTS)
    suspend fun getHorses(): Response<HorseResponse>
}