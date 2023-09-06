package com.testwork.hotels.ui.fourth_fragment.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class SuccessViewModel : ViewModel() {

    companion object {
        const val MIN_ORDER_NUMBER = 0
        const val MAX_ORDER_NUMBER = 999999
    }

    fun getOrderNumber(): Flow<Int> {
        return flow {
            emit(Random.nextInt(MIN_ORDER_NUMBER, MAX_ORDER_NUMBER))
        }
    }
}