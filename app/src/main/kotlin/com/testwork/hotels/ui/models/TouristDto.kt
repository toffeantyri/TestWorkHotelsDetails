package com.testwork.hotels.ui.models

data class TouristDto(
    var firstName: String = "",
    var secondName: String = "",
    var dateOfBirth: String = "",
    var citizenShip: String = "",
    var passportNumbers: String = "",
    var endDateOfPassport: String = "",
    var needValidate: Boolean = false
) {
    fun fieldsIsNotEmpty(): Boolean {
        return firstName.isNotBlank()
                && secondName.isNotBlank()
                && dateOfBirth.isNotBlank()
                && citizenShip.isNotBlank()
                && passportNumbers.isNotBlank()
                && endDateOfPassport.isNotBlank()
    }
}