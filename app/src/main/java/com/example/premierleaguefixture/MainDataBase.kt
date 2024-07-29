package com.example.premierleaguefixture

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [MatchDetails::class], version = 1)
abstract class MainDataBase : RoomDatabase() {

    abstract fun matchDao(): Dao

    companion object {
        private var INSTANCE: MainDataBase? = null
        fun createDateBase(context: Context): Boolean {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        MainDataBase::class.java,
                        "MainDataBase")
                        .build()
                    return true
                }
            }
            return false
        }

        fun getDataBase(): MainDataBase? = INSTANCE
    }
}