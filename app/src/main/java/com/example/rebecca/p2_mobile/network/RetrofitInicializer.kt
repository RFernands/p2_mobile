package com.example.rebecca.p2_mobile.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInicializer {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.thecocktaildb.com/api/json/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun createNewsService() = retrofit.create(DrinksService::class.java)

}