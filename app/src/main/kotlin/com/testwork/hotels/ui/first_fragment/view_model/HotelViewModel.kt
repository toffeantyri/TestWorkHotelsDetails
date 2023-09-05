package com.testwork.hotels.ui.first_fragment.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testwork.domain.models.HotelDto
import com.testwork.domain.use_cases.GetHotelDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HotelViewModel(private val getHotelDataUseCase: GetHotelDataUseCase) : ViewModel() {

    private val _hotelLiveData: MutableLiveData<HotelDto> by lazy {
        MutableLiveData()
    }
    val hotelLiveData: LiveData<HotelDto> get() = _hotelLiveData

    init {
        getHotelData()
    }

    private fun getHotelData() {
        viewModelScope.launch {
            runCatching {
                withContext(Dispatchers.IO) {
                    getHotelDataUseCase.execute()
                }
            }.onSuccess {
                _hotelLiveData.value = it
            }.onFailure {
                Log.d("MyLog", "VM: ERROR $it")
            }
        }
    }


}