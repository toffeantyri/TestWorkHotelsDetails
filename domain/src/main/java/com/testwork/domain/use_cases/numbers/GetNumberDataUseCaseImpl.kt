package com.testwork.domain.use_cases.numbers

import com.testwork.data.repository.numbers_repo.GetNumbersRepository
import com.testwork.domain.mappers.UNKNOWN_INT
import com.testwork.domain.models.LinkWrapperDto
import com.testwork.domain.models.RoomDto

class GetNumberDataUseCaseImpl(private val repo: GetNumbersRepository) : GetNumberDataUseCase {
    override suspend fun execute(): List<RoomDto> {
        return repo.getNumbers().map {
            RoomDto(
                id = it.id ?: UNKNOWN_INT,
                imageUrls = it.imageUrls?.map { link -> LinkWrapperDto(link ?: "") } ?: emptyList(),
                name = it.name ?: "",
                peculiarities = it.peculiarities?.mapNotNull { pec -> pec } ?: emptyList(),
                price = it.price ?: UNKNOWN_INT,
                pricePer = it.pricePer ?: ""
            )
        }
    }


}