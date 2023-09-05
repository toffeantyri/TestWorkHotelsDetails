package com.testwork.domain.use_cases

import com.testwork.data.repository.hotels_repo.GetHotelsDataRepository
import com.testwork.domain.mappers.toHotelDto
import com.testwork.domain.models.HotelDto

class GetHotelDataUseCaseImpl(private val repo: GetHotelsDataRepository) : GetHotelDataUseCase {
    override suspend fun execute(): HotelDto {
        val result = repo.getHotelsData()
        return result.toHotelDto()
    }
}