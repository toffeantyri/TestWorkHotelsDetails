package com.testwork.data.data_source.numbers_ds

import com.testwork.data.models.remote.numbers.RemoteNumbersDto

interface GetNumbersRemoteDataSource {

    suspend fun getNumbers(): RemoteNumbersDto
}