package com.testwork.domain.use_cases.hotels

import com.testwork.domain.models.HotelDto

interface GetHotelDataUseCase {
    suspend fun execute(): HotelDto
}