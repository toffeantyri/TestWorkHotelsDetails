package com.testwork.data.di

import com.testwork.data.data_source.hotels_ds.GetHotelDataRemoteSourceImpl
import com.testwork.data.data_source.hotels_ds.GetHotelsDataRemoteSource
import com.testwork.data.data_source.numbers_ds.GetNumbersRemoteDataSource
import com.testwork.data.data_source.numbers_ds.GetNumbersRemoteDataSourceImpl
import com.testwork.data.data_source.reservation_ds.ReservationRemoteDataSource
import com.testwork.data.data_source.reservation_ds.ReservationRemoteDataSourceImpl
import com.testwork.data.repository.hotels_repo.GetHotelDataRepositoryImpl
import com.testwork.data.repository.hotels_repo.GetHotelsDataRepository
import com.testwork.data.repository.numbers_repo.GetNumbersRepository
import com.testwork.data.repository.numbers_repo.GetNumbersRepositoryImpl
import com.testwork.data.repository.reservation.ReservationRepository
import com.testwork.data.repository.reservation.ReservationRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    factory<GetHotelsDataRemoteSource>(named(NAMED_HOTEL_REMOTE_DS)) {
        GetHotelDataRemoteSourceImpl(get(named(NAMED_API_SERVICE)))
    }

    factory<GetHotelsDataRepository>(named(NAMED_HOTEL_REMOTE_REPO)) {
        GetHotelDataRepositoryImpl(get(named(NAMED_HOTEL_REMOTE_DS)))
    }

    factory<GetNumbersRemoteDataSource>(named(NAMED_NUMBERS_REMOTE_DS)) {
        GetNumbersRemoteDataSourceImpl(get(named(NAMED_API_SERVICE)))
    }

    factory<GetNumbersRepository>(named(NAMED_NUMBERS_REMOTE_REPO)) {
        GetNumbersRepositoryImpl(get(named(NAMED_NUMBERS_REMOTE_DS)))
    }

    factory<ReservationRemoteDataSource>(named(NAMED_RESERVATION_REMOTE_DS)) {
        ReservationRemoteDataSourceImpl(get(named(NAMED_API_SERVICE)))
    }

    factory<ReservationRepository>(named(NAMED_RESERVATION_REMOTE_REPO)) {
        ReservationRepositoryImpl(get(named(NAMED_RESERVATION_REMOTE_DS)))
    }
}