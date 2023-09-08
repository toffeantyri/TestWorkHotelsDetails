package com.testwork.domain.models.exeptions

class ValidateColumnException(override val message: String?) : IllegalStateException(message)