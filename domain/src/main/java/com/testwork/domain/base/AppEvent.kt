package com.testwork.domain.base

sealed interface AppEvent<T> {
    data class Success<T>(val data: T) : AppEvent<T>
    data class Error<T>(val error: Throwable?) : AppEvent<T>
    class Loading<T>() : AppEvent<T>

}