package com.testwork.domain.use_cases.hotels

import com.testwork.domain.models.pres_model.HotelDto

interface GetHotelDataUseCase {
    suspend fun execute(): HotelDto
}