package com.testwork.data.data_source

import com.testwork.data.models.remote.RemoteHotelDto

class GetHotelDataRemoteSourceImpl(private val api: ApiService) : GetHotelsDataRemoteSource {
    override suspend fun getHotelsData(): RemoteHotelDto {
        return api.getHotelData()
    }
}