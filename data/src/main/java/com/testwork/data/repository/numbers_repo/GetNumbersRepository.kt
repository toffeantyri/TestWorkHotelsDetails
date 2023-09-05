package com.testwork.data.repository.numbers_repo

import com.testwork.data.models.remote.numbers.Room

interface GetNumbersRepository {
    suspend fun getNumbers(): List<Room>

}