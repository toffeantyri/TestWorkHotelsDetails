package com.testwork.data.models.remote.numbers

import com.squareup.moshi.Json

data class Room(
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "image_urls") val imageUrls: List<String?>?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "peculiarities") val peculiarities: List<String?>?,
    @field:Json(name = "price") val price: Int?,
    @field:Json(name = "price_per") val pricePer: String?
)