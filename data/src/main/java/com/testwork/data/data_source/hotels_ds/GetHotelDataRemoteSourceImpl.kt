package com.testwork.data.data_source.hotels_ds

import com.testwork.data.data_source.ApiService
import com.testwork.data.models.remote.hotel.RemoteHotelDto

class GetHotelDataRemoteSourceImpl(private val api: ApiService) : GetHotelsDataRemoteSource {
    override suspend fun getHotelsData(): RemoteHotelDto {
        return api.getHotelData()
    }
}