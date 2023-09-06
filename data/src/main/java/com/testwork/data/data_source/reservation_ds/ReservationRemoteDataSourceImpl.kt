package com.testwork.data.data_source.reservation_ds

import com.testwork.data.data_source.ApiService
import com.testwork.data.models.remote.reservation.RemoteReservationDto

class ReservationRemoteDataSourceImpl(private val api: ApiService) : ReservationRemoteDataSource {
    override suspend fun getReservationData(): RemoteReservationDto {
        return api.getReservationData()
    }

}