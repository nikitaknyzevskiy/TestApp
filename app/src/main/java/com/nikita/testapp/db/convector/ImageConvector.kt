package com.nikita.testapp.db.convector

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.nikita.testapp.db.model.ext.LargeModel

class ImageConvector {

    @TypeConverter
    fun fromData(image: LargeModel): String {
        return Gson().toJson(image)
    }

    @TypeConverter
    fun toData(data: String): LargeModel {
        return Gson().fromJson(data, LargeModel::class.java)
    }

}