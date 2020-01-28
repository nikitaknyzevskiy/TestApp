package com.nikita.testapp.db.dto

import androidx.annotation.NonNull
import com.nikita.testapp.db.model.ext.IdModel
import com.nikita.testapp.db.model.ext.LargeModel
import com.nikita.testapp.db.model.ext.NameModel

data class UserModel (

    val id: IdModel,

    val gender: String,

    val name: NameModel,

    val email: String,

    val phone: String,

    val cell: String,

    val picture: LargeModel
)