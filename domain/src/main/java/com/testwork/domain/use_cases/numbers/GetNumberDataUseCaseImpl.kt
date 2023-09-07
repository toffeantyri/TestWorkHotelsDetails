package com.testwork.domain.use_cases.numbers

import com.testwork.data.repository.numbers_repo.GetNumbersRepository
import com.testwork.domain.mappers.toRoomDto
import com.testwork.domain.models.pres_model.RoomDto

class GetNumberDataUseCaseImpl(private val repo: GetNumbersRepository) : GetNumberDataUseCase {
    override suspend fun execute(): List<RoomDto> {
        return repo.getNumbers().map { it.toRoomDto() }
    }


}