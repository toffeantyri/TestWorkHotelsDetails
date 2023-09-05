package com.testwork.domain.models

data class HotelDto(
    val address: String,
    val id: Int,
    val imageUrls: List<LinkWrapperDto>,
    val minimalPrice: Int,
    val name: String,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String,
    val description: String,
    val peculiarities: List<String>
) : DelegateAdapterItem {
    override fun id(): Any {
        return id
    }

    override fun content(): Any {
        return this
    }

}
