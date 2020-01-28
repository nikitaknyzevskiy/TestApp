package com.nikita.testapp.db.model.UserModel

import androidx.room.Entity
import com.nikita.testapp.db.model.ext.LargeModel
import com.nikita.testapp.db.model.ext.NameModel

@Entity
data class UserModel (
    val gender: String,

    val name: NameModel,

    val email: String,

    val phone: String,

    val cell: String,

    val picture: LargeModel
)