package com.testwork.domain.models.pres_model

import com.testwork.domain.models.DelegateAdapterItem

data class RoomDto(
    val id: Int,
    val imageUrls: List<LinkWrapperDto>,
    val name: String,
    val peculiarities: List<String>,
    val price: Int,
    val pricePer: String
) : DelegateAdapterItem {
    override fun id(): Any {
        return id
    }

    override fun content(): Any {
        return this
    }

}
