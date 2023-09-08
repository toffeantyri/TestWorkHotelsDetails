package com.testwork.data.data_source.reservation_ds

import com.testwork.data.models.remote.reservation.RemoteReservationDto

interface ReservationRemoteDataSource {
    suspend fun getReservationData(): RemoteReservationDto
}