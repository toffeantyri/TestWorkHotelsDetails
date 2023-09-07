package com.testwork.hotels.ui.models

import com.testwork.domain.models.DelegateAdapterItem

data class TouristDto(
    var firstName: String = "",
    var secondName: String = "",
    var dateOfBirth: String = "",
    var citizenShip: String = "",
    var passportNumbers: String = "",
    var endDateOfPassport: String = "",
    var isOpen: Boolean = false
) : DelegateAdapterItem {
    override fun id(): Any {
        return firstName + secondName
    }

    override fun content(): Any {
        return false
    }
}