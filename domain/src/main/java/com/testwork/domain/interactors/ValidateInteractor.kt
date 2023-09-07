package com.testwork.domain.interactors

import com.testwork.domain.base.AppEvent
import kotlinx.coroutines.flow.Flow


interface ValidateInteractor {
    suspend fun checkUserEmail(value: String): Flow<AppEvent<*>>
    suspend fun validateNumber(value: String): Flow<AppEvent<String>>
}

