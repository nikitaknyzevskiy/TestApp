package com.nikita.testapp.db.convector

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.nikita.testapp.db.model.ext.NameModel


class NameConvector {

    @TypeConverter
    fun fromData(name: NameModel): String {
        return Gson().toJson(name)
    }

    @TypeConverter
    fun toData(data: String): NameModel {
        return Gson().fromJson(data, NameModel::class.java)
    }

}