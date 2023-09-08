package com.testwork.hotels.ui.third_fragment.reservation_adapter

interface DataChangerCallbackInterface {
    fun nameChanged(pos: Int, text: String)
    fun secondNameChanged(pos: Int, text: String)
    fun dateOfBirthChanged(pos: Int, text: String)
    fun citizenshipChanged(pos: Int, text: String)
    fun paspNumberChanged(pos: Int, text: String)
    fun paspEndDateChanged(pos: Int, text: String)

}