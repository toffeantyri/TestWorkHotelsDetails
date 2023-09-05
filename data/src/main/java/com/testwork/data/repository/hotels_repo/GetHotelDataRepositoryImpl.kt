package com.testwork.data.repository.hotels_repo

import android.util.Log
import com.testwork.data.TAG
import com.testwork.data.data_source.hotels_ds.GetHotelsDataRemoteSource
import com.testwork.data.models.remote.hotel.RemoteHotelDto

class GetHotelDataRepositoryImpl(private val remoteDataSource: GetHotelsDataRemoteSource) :
    GetHotelsDataRepository {
    override suspend fun getHotelsData(): RemoteHotelDto {
        val result = remoteDataSource.getHotelsData()
        Log.d(TAG, "REPO: $result")
        return result
    }
}