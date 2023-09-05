package com.testwork.domain.models

data class RoomDto(
    val id: Int,
    val imageUrls: List<LinkWrapperDto>,
    val name: String,
    val peculiarities: List<String>,
    val price: Int,
    val pricePer: String
)
