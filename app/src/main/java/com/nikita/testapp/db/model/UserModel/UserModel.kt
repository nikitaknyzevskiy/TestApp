package com.nikita.testapp.db.model.UserModel

import com.nikita.testapp.db.model.ext.LargeModel
import com.nikita.testapp.db.model.ext.NameModel

data class UserModel (
    val gender: String,

    val name: NameModel,

    val email: String,

    val phone: String,

    val cell: String,

    val picture: LargeModel
)