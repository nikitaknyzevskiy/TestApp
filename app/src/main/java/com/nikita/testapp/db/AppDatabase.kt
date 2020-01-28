package com.nikita.testapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nikita.testapp.db.convector.NameConvector
import com.nikita.testapp.db.model.UserModel.UserModel

@Database(entities = [UserModel::class], version = 1)
@TypeConverters(NameConvector::class)
abstract class AppDatabase : RoomDatabase() {

}