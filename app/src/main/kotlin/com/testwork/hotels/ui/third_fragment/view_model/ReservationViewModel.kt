package com.testwork.hotels.ui.third_fragment.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testwork.domain.base.AppEvent
import com.testwork.domain.interactors.ValidateInteractor
import com.testwork.domain.models.pres_model.ReservationDto
import com.testwork.domain.use_cases.reservation.ReservationUseCase
import com.testwork.hotels.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReservationViewModel(
    private val reservationUseCase: ReservationUseCase,
    private val validator: ValidateInteractor
) : ViewModel() {

    private val _validatePhoneLiveData: MutableLiveData<AppEvent<*>> by lazy {
        MutableLiveData()
    }
    val validatePhoneLiveData: LiveData<AppEvent<*>> get() = _validatePhoneLiveData


    private val _validateEmailLiveData: MutableLiveData<AppEvent<*>> by lazy {
        MutableLiveData()
    }
    val validateEmailLiveData: LiveData<AppEvent<*>> get() = _validateEmailLiveData

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

    fun formatNumber(number: String): String {
        return number.replace(Regex("\\D"), "")
    }

    fun validatePhoneNumber(number: String) {
        viewModelScope.launch {
            val formatNumber = formatNumber(number)
            validator.validateNumber(formatNumber).collect { state ->
                _validatePhoneLiveData.value = state
            }
        }
    }

    fun validateUserEmail(value: String) {
        viewModelScope.launch {
            validator.checkUserEmail(value).collect {
                _validateEmailLiveData.value = it
            }
        }
    }


}