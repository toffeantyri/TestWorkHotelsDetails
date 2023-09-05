package com.testwork.hotels.di

import com.testwork.hotels.ui.first_fragment.view_model.HotelViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val presentationModule = module {

    viewModel { HotelViewModel(getHotelDataUseCase = get(named(NAMED_GET_HOTEL_USE_CASE))) }

}