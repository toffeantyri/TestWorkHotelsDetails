package com.testwork.hotels.di

import com.testwork.data.di.NAMED_HOTEL_REMOTE_REPO
import com.testwork.domain.use_cases.GetHotelDataUseCase
import com.testwork.domain.use_cases.GetHotelDataUseCaseImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val domainModule = module {

    factory<GetHotelDataUseCase>(named(NAMED_GET_HOTEL_USE_CASE)) {
        GetHotelDataUseCaseImpl(get(named(NAMED_HOTEL_REMOTE_REPO)))
    }

}