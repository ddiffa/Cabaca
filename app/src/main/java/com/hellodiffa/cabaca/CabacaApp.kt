package com.hellodiffa.cabaca

import android.app.Application
import com.hellodiffa.cabaca.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CabacaApp : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CabacaApp)
            modules(networkModule)
        }
    }
}