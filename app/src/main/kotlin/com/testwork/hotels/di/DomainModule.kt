package com.testwork.hotels.di

import com.testwork.data.di.NAMED_HOTEL_REMOTE_REPO
import com.testwork.data.di.NAMED_NUMBERS_REMOTE_REPO
import com.testwork.data.di.NAMED_RESERVATION_REMOTE_REPO
import com.testwork.data.di.NAMED_VALIDATE_INTERACTOR
import com.testwork.domain.interactors.ValidateInteractor
import com.testwork.domain.interactors.ValidateInteractorImpl
import com.testwork.domain.use_cases.hotels.GetHotelDataUseCase
import com.testwork.domain.use_cases.hotels.GetHotelDataUseCaseImpl
import com.testwork.domain.use_cases.numbers.GetNumberDataUseCase
import com.testwork.domain.use_cases.numbers.GetNumberDataUseCaseImpl
import com.testwork.domain.use_cases.reservation.ReservationUseCase
import com.testwork.domain.use_cases.reservation.ReservationUseCaseImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val domainModule = module {

    factory<GetHotelDataUseCase>(named(NAMED_GET_HOTEL_USE_CASE)) {
        GetHotelDataUseCaseImpl(get(named(NAMED_HOTEL_REMOTE_REPO)))
    }

    factory<GetNumberDataUseCase>(named(NAMED_GET_NUMBERS_USE_CASE)) {
        GetNumberDataUseCaseImpl(get(named(NAMED_NUMBERS_REMOTE_REPO)))
    }

    factory<ReservationUseCase>(named(NAMED_GET_RESERVATION_USE_CASE)) {
        ReservationUseCaseImpl(get(named(NAMED_RESERVATION_REMOTE_REPO)))
    }

    factory<ValidateInteractor>(named(NAMED_VALIDATE_INTERACTOR)) { ValidateInteractorImpl() }
}
