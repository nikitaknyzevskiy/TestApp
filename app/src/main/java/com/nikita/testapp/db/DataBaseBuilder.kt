package com.nikita.testapp.db

import androidx.room.Room
import com.nikita.testapp.MyApp

object DataBaseBuilder {

    val db: AppDatabase by lazy {
        Room.databaseBuilder(
            MyApp::class.java.newInstance().applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }

}