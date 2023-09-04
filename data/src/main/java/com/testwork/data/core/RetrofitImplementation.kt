package com.testwork.data.core

import com.squareup.moshi.Moshi
import com.testwork.data.data_source.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitImplementation() {

    fun getService(adapter: Moshi): ApiService {
        return createRetrofit(adapter).create(ApiService::class.java)
    }

    private fun createRetrofit(adapter: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://run.mocky.io/")
            .addConverterFactory(
                MoshiConverterFactory
                    .create(adapter)
            )
            .client(createOkHttpClient())
            .build()
    }

    private fun createOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder().apply {
            connectTimeout(TIME_OUT_CONNECT, TimeUnit.SECONDS)
            readTimeout(TIME_OUT_CONNECT, TimeUnit.SECONDS)
        }
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            httpClient.addInterceptor(interceptor)
        }
        return httpClient.build()
    }

    private companion object {
        const val TIME_OUT_CONNECT = 30L
    }
}