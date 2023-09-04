package com.testwork.data.repository

import android.util.Log
import com.testwork.data.TAG
import com.testwork.data.data_source.GetHotelsDataRemoteSource
import com.testwork.data.models.remote.RemoteHotelDto

class GetHotelDataRepositoryImpl(private val remoteDataSource: GetHotelsDataRemoteSource) :
    GetHotelsDataRepository {
    override suspend fun getHotelsData(): RemoteHotelDto {
        val result = remoteDataSource.getHotelsData()
        Log.d(TAG, "REPO: $result")
        return result
    }
}