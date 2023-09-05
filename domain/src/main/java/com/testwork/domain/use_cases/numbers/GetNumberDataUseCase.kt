package com.testwork.domain.use_cases.numbers

import com.testwork.domain.models.RoomDto

interface GetNumberDataUseCase {
    suspend fun execute(): List<RoomDto>
}