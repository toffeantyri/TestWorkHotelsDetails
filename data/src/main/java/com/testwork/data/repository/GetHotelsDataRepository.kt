package com.testwork.data.repository

import com.testwork.data.models.remote.RemoteHotelDto

interface GetHotelsDataRepository {
    suspend fun getHotelsData(): RemoteHotelDto
}