package com.example.premierleaguefixture

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

       // startKoin {
          //  modules(appModule)
       // }
    }
}