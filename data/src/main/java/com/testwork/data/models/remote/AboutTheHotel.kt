package com.testwork.data.models.remote

import com.squareup.moshi.Json

data class AboutTheHotel(
    @field: Json(name = "description") val description: String?,
    @field: Json(name = "peculiarities") val peculiarities: List<String?>?
)