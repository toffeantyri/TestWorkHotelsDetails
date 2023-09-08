package com.testwork.data.repository.numbers_repo

import com.testwork.data.data_source.numbers_ds.GetNumbersRemoteDataSource
import com.testwork.data.models.remote.numbers.Room

class GetNumbersRepositoryImpl(private val getNumbersRemoteDataSource: GetNumbersRemoteDataSource) :
    GetNumbersRepository {
    override suspend fun getNumbers(): List<Room> {
        return getNumbersRemoteDataSource.getNumbers().rooms?.mapNotNull {
            it
        } ?: emptyList()
    }


}