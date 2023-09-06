package com.testwork.data.repository.reservation

import com.testwork.data.data_source.reservation_ds.ReservationRemoteDataSource
import com.testwork.data.models.remote.reservation.RemoteReservationDto

class ReservationRepositoryImpl(private val remoteDs: ReservationRemoteDataSource) :
    ReservationRepository {
    override suspend fun getReservationData(): RemoteReservationDto {
        return remoteDs.getReservationData()
    }

}