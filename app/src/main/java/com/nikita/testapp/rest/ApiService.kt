package com.nikita.testapp.rest

import com.nikita.testapp.db.dto.UserDto
import com.nikita.testapp.db.model.UserModel.UserModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/")
    suspend fun userList(@Query("results") results: Int = 20): BaseResponse<List<UserDto>>

}