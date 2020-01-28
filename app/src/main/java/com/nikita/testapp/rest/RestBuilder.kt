package com.nikita.testapp.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RestBuilder {

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val rest: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}