package com.testwork.hotels.ui.third_fragment.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.testwork.domain.models.ReservationDto
import com.testwork.domain.use_cases.reservation.ReservationUseCase

class ReservationViewModel(private val reservationUseCase: ReservationUseCase) : ViewModel() {

    private val _reservationLiveData: MutableLiveData<ReservationDto> by lazy {
        MutableLiveData()
    }
    val reservationLiveData: LiveData<ReservationDto> get() = _reservationLiveData

    init {
        getReservationData()
    }

    private fun getReservationData() {

    }

}