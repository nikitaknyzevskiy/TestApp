package com.nikita.testapp.rest

import retrofit2.Retrofit




object RestBuilder {

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .build()

    val rest: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}