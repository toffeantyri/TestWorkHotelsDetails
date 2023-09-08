package com.testwork.data.data_source.numbers_ds

import com.testwork.data.data_source.ApiService
import com.testwork.data.models.remote.numbers.RemoteNumbersDto

class GetNumbersRemoteDataSourceImpl(private val api: ApiService) : GetNumbersRemoteDataSource {
    override suspend fun getNumbers(): RemoteNumbersDto {
        return api.getNumbers()
    }


}