package com.testwork.hotels.ui.third_fragment.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testwork.domain.models.ReservationDto
import com.testwork.domain.use_cases.reservation.ReservationUseCase
import com.testwork.hotels.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReservationViewModel(
    private val reservationUseCase: ReservationUseCase
) : ViewModel() {

    private val _reservationLiveData: MutableLiveData<ReservationDto> by lazy {
        MutableLiveData()
    }
    val reservationLiveData: LiveData<ReservationDto> get() = _reservationLiveData

    init {
        getReservationData()
    }

    private fun getReservationData() {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    reservationUseCase.execute()
                }
            }.onSuccess {
                _reservationLiveData.value = it
            }.onFailure {
                Log.d(TAG, "VM: $it")
            }
        }
    }



}