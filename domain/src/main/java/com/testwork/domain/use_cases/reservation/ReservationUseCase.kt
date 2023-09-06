package com.testwork.domain.use_cases.reservation

import com.testwork.domain.models.ReservationDto

interface ReservationUseCase {

    suspend fun execute(): ReservationDto

}