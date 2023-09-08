package com.testwork.domain.interactors

import com.testwork.domain.base.AppEvent
import com.testwork.domain.models.exeptions.EmailValidateException
import com.testwork.domain.models.exeptions.ValidateColumnException
import com.testwork.domain.util.EMAIL_EXP
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class ValidateInteractorImpl : ValidateInteractor {
    companion object {
        const val NUMBER_LENGTH = 11
    }


    override suspend fun checkUserEmail(value: String): Flow<AppEvent<String>> {
        return flow {
            val isCorrectUserEmail = isCorrectUserEmail(value)
            val result = isCorrectUserEmail.first
            if (result) {
                emit(AppEvent.Success(value))
            } else {
                val message = isCorrectUserEmail.second
                emit(AppEvent.Error(EmailValidateException(message)))
            }
        }.catch {
            emit(AppEvent.Error(it))
        }.flowOn(Dispatchers.IO)
    }

    private fun isCorrectUserEmail(value: String): Pair<Boolean, String?> {
        val pattern = EMAIL_EXP.toRegex()
        return if (!pattern.matches(value)) {
            false to "Некорректный адрес электронной почты"
        } else {
            true to null
        }
    }

    override suspend fun validateNumber(value: String): Flow<AppEvent<String>> = flow {
        if (value.length != NUMBER_LENGTH) {
            emit(AppEvent.Error(ValidateColumnException("Проверьте длину символов")))
        } else {
            emit(AppEvent.Success("Success"))
        }

    }.catch {
        emit(AppEvent.Error(it))
    }.flowOn(Dispatchers.Default)


}