package com.testwork.hotels.di

import com.testwork.hotels.ui.first_fragment.view_model.HotelViewModel
import com.testwork.hotels.ui.fourth_fragment.viewmodel.SuccessViewModel
import com.testwork.hotels.ui.second_fragment.view_model.NumbersViewModel
import com.testwork.hotels.ui.third_fragment.view_model.ReservationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val presentationModule = module {

    viewModel { HotelViewModel(getHotelDataUseCase = get(named(NAMED_GET_HOTEL_USE_CASE))) }

    viewModel { NumbersViewModel(numbersDataUseCase = get(named(NAMED_GET_NUMBERS_USE_CASE))) }

    viewModel { ReservationViewModel() } //todo

    viewModel { SuccessViewModel() } //todo

}