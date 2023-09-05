package com.testwork.data.data_source.hotels_ds

import com.testwork.data.models.remote.hotel.RemoteHotelDto

interface GetHotelsDataRemoteSource {
    suspend fun getHotelsData(): RemoteHotelDto
}