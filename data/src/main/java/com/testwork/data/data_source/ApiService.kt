package com.testwork.data.data_source

import com.testwork.data.models.remote.hotel.RemoteHotelDto
import com.testwork.data.models.remote.numbers.RemoteNumbersDto
import com.testwork.data.models.remote.reservation.RemoteReservationDto
import retrofit2.http.GET

interface ApiService {
    @GET("v3/35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotelData(): RemoteHotelDto

    @GET("v3/f9a38183-6f95-43aa-853a-9c83cbb05ecd")
    suspend fun getNumbers(): RemoteNumbersDto


    @GET("v3/e8868481-743f-4eb2-a0d7-2bc4012275c8")
    suspend fun getReservationData(): RemoteReservationDto
}