package com.trianglz.android_testing.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HorseResponseItem(
    @Json(name = "body")
    var body: String,
    @Json(name = "id")
    var id: Int,
    @Json(name = "title")
    var title: String,
    @Json(name = "userId")
    var userId: Int
)