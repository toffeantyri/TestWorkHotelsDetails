package com.testwork.data.models.remote.hotel

import com.squareup.moshi.Json

data class RemoteHotelDto(
    @field: Json(name = "about_the_hotel") val aboutTheHotel: AboutTheHotel?,
    @field: Json(name = "adress") val address: String?,
    @field: Json(name = "id") val id: Int?,
    @field: Json(name = "image_urls") val imageUrls: List<String?>?,
    @field: Json(name = "minimal_price") val minimalPrice: Int?,
    @field: Json(name = "name") val name: String?,
    @field: Json(name = "price_for_it") val priceForIt: String?,
    @field: Json(name = "rating") val rating: Int?,
    @field: Json(name = "rating_name") val ratingName: String?
)