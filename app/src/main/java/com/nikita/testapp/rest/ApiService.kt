package com.nikita.testapp.rest

import com.nikita.testapp.db.model.UserModel.UserModel
import retrofit2.http.GET

interface ApiService {

    @GET("api")
    suspend fun userList(): List<UserModel>

}