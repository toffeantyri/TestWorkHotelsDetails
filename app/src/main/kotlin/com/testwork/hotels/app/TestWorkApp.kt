package com.testwork.hotels.app

import android.app.Application
import com.testwork.data.di.dataModule
import com.testwork.data.di.networkModule
import com.testwork.hotels.di.domainModule
import com.testwork.hotels.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TestWorkApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TestWorkApp)
            modules(
                networkModule,
                dataModule,
                domainModule,
                presentationModule
            )
        }

    }


}