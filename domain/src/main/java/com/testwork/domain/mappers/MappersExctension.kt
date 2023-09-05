package com.testwork.domain.mappers

import com.testwork.data.models.remote.RemoteHotelDto
import com.testwork.domain.models.HotelDto
import com.testwork.domain.models.LinkWrapperDto

const val UNKNOWN_INT = -1
fun RemoteHotelDto.toHotelDto(): HotelDto {
    return HotelDto(
        address = this.address ?: "",
        id = this.id ?: UNKNOWN_INT,
        imageUrls = this.imageUrls?.mapNotNull { if (it != null) LinkWrapperDto(it) else null }
            ?: emptyList(),
        minimalPrice = this.minimalPrice ?: UNKNOWN_INT,
        name = this.name ?: "",
        priceForIt = this.priceForIt ?: "",
        rating = this.rating ?: UNKNOWN_INT,
        ratingName = this.ratingName ?: "",
        description = this.aboutTheHotel?.description ?: "",
        peculiarities = this.aboutTheHotel?.peculiarities?.mapNotNull { it } ?: emptyList()
    )
}