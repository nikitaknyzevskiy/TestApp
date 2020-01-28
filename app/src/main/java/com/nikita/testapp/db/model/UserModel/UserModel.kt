package com.nikita.testapp.db.model.UserModel

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nikita.testapp.db.model.ext.LargeModel
import com.nikita.testapp.db.model.ext.NameModel

@Entity
data class UserModel (

    @PrimaryKey
    @NonNull
    val id: String,

    val gender: String,

    val name: NameModel,

    val email: String,

    val phone: String,

    val cell: String,

    val picture: LargeModel
)