package com.testwork.domain.use_cases

import com.testwork.domain.models.HotelDto

interface GetHotelDataUseCase {
    suspend fun execute(): HotelDto
}