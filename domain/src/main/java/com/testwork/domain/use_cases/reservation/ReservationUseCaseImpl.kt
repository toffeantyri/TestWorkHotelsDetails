package com.testwork.domain.use_cases.reservation

import com.testwork.data.repository.reservation.ReservationRepository
import com.testwork.domain.mappers.toReservationDto
import com.testwork.domain.models.pres_model.ReservationDto

class ReservationUseCaseImpl(private val repo: ReservationRepository) : ReservationUseCase {
    override suspend fun execute(): ReservationDto {
        return repo.getReservationData().toReservationDto()
    }


}