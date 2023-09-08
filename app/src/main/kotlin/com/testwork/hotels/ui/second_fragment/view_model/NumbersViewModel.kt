package com.testwork.hotels.ui.second_fragment.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testwork.domain.models.pres_model.RoomDto
import com.testwork.domain.use_cases.numbers.GetNumberDataUseCase
import com.testwork.hotels.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NumbersViewModel(private val numbersDataUseCase: GetNumberDataUseCase) : ViewModel() {

    private val _numbersLiveData: MutableLiveData<List<RoomDto>> by lazy {
        MutableLiveData()
    }
    val numbersLiveData: LiveData<List<RoomDto>> get() = _numbersLiveData

    init {
        getNumbersListData()
    }

    private fun getNumbersListData() {
        viewModelScope.launch {
            runCatching {
                withContext(Dispatchers.IO) {
                    numbersDataUseCase.execute()
                }
            }.onSuccess {
                _numbersLiveData.value = it
            }.onFailure {
                Log.d(TAG, "VM: ERROR $it")
            }
        }
    }


}