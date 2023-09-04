package com.testwork.data.data_source

import com.testwork.data.models.remote.RemoteHotelDto
import retrofit2.http.GET

interface ApiService {
    @GET("v3/35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotelData(): RemoteHotelDto

}