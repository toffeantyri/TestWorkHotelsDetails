package com.testwork.data.di

import com.squareup.moshi.Moshi
import com.testwork.data.core.RetrofitImplementation
import com.testwork.data.data_source.ApiService
import org.koin.core.qualifier.named
import org.koin.dsl.module


val networkModule = module {

    factory<ApiService>(named(NAMED_API_SERVICE)) {
        get<RetrofitImplementation>(named(NAMED_RETROFIT)).getService(
            get(named(NAMED_MOSHI))
        )
    }

    factory<Moshi>(named(NAMED_MOSHI)) {
        Moshi.Builder().build()
    }

    single(named(NAMED_RETROFIT)) {
        RetrofitImplementation()
    }

}