package com.testwork.data.data_source

import com.testwork.data.models.remote.RemoteHotelDto

interface GetHotelsDataRemoteSource {
    suspend fun getHotelsData(): RemoteHotelDto
}