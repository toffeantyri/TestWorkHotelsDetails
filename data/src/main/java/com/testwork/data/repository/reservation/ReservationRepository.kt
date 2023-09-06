package com.testwork.data.repository.reservation

import com.testwork.data.models.remote.reservation.RemoteReservationDto

interface ReservationRepository {
    suspend fun getReservationData(): RemoteReservationDto
}