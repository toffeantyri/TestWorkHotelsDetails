package com.testwork.domain.models.exeptions

class EmailValidateException(override val message: String?) : IllegalStateException(message) {
}