package com.example.premierleaguefixture

import androidx.room.Room
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://fixturedownload.com/feed/json/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        Room.databaseBuilder(
            get(),
            MainDataBase::class.java,
            "MainDataBase")
            .build()
    }
}