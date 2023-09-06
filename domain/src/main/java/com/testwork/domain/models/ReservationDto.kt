package com.testwork.domain.models

data class ReservationDto(
    val arrivalCountry: String,
    val departure: String,
    val fuelCharge: Int,
    val horating: Int,
    val hotelAddress: String,
    val hotelName: String,
    val id: Int,
    val numberOfNights: Int,
    val nutrition: String,
    val ratingName: String,
    val room: String,
    val serviceCharge: Int,
    val tourDateStart: String,
    val tourDateStop: String,
    val tourPrice: Int
) : DelegateAdapterItem {
    override fun id(): Any {
        return id
    }

    override fun content(): Any {
        return this
    }
}