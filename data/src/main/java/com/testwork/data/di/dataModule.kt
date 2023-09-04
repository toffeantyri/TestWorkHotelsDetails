package com.testwork.data.di

import com.testwork.data.data_source.GetHotelDataRemoteSourceImpl
import com.testwork.data.data_source.GetHotelsDataRemoteSource
import com.testwork.data.repository.GetHotelDataRepositoryImpl
import com.testwork.data.repository.GetHotelsDataRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    factory<GetHotelsDataRemoteSource>(named(NAMED_HOTEL_REMOTE_DS)) {
        GetHotelDataRemoteSourceImpl(get(named(NAMED_API_SERVICE)))
    }

    factory<GetHotelsDataRepository>(named(NAMED_HOTEL_REMOTE_REPO)) {
        GetHotelDataRepositoryImpl(get(named(NAMED_HOTEL_REMOTE_DS)))
    }
}