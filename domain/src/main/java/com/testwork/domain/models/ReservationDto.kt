package com.testwork.domain.models

data class ReservationDto(val id: Int) : DelegateAdapterItem {
    override fun id(): Any {
        return id
    }

    override fun content(): Any {
        return this
    }
}