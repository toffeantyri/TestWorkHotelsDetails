package com.testwork.domain.use_cases.reservation

import com.testwork.domain.models.pres_model.ReservationDto

interface ReservationUseCase {

    suspend fun execute(): ReservationDto

}