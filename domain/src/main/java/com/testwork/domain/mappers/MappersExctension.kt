package com.testwork.domain.mappers

import com.testwork.data.models.remote.hotel.RemoteHotelDto
import com.testwork.data.models.remote.numbers.Room
import com.testwork.data.models.remote.reservation.RemoteReservationDto
import com.testwork.domain.models.HotelDto
import com.testwork.domain.models.LinkWrapperDto
import com.testwork.domain.models.ReservationDto
import com.testwork.domain.models.RoomDto

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

fun Room.toRoomDto(): RoomDto {
    return RoomDto(
        id = this.id ?: UNKNOWN_INT,
        imageUrls = this.imageUrls?.map { link -> LinkWrapperDto(link ?: "") } ?: emptyList(),
        name = this.name ?: "",
        peculiarities = this.peculiarities?.mapNotNull { pec -> pec } ?: emptyList(),
        price = this.price ?: UNKNOWN_INT,
        pricePer = this.pricePer ?: ""
    )
}

fun RemoteReservationDto.toReservationDto(): ReservationDto {
    return ReservationDto(
        id = this.id ?: UNKNOWN_INT,
        arrivalCountry = this.arrivalCountry ?: "",
        departure = this.departure ?: "",
        fuelCharge = this.fuelCharge ?: UNKNOWN_INT,
        horating = this.horating ?: UNKNOWN_INT,
        hotelAddress = this.hotelAddress ?: "",
        hotelName = this.hotelName ?: "",
        numberOfNights = this.numberOfNights ?: UNKNOWN_INT,
        nutrition = this.nutrition ?: "",
        ratingName = this.ratingName ?: "",
        room = this.room ?: "",
        serviceCharge = this.serviceCharge ?: UNKNOWN_INT,
        tourDateStart = this.tourDateStart ?: "",
        tourDateStop = this.tourDateStop ?: "",
        tourPrice = this.tourPrice ?: UNKNOWN_INT
    )
}