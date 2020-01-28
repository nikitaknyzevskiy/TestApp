package com.nikita.testapp

import android.app.Application
import androidx.room.Room
import com.nikita.testapp.db.AppDatabase
import com.nikita.testapp.db.DataBaseBuilder

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        DataBaseBuilder.db = Room.databaseBuilder(
            this.applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}