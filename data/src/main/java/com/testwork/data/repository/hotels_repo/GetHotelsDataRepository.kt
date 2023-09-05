package com.testwork.data.repository.hotels_repo

import com.testwork.data.models.remote.hotel.RemoteHotelDto

interface GetHotelsDataRepository {
    suspend fun getHotelsData(): RemoteHotelDto
}