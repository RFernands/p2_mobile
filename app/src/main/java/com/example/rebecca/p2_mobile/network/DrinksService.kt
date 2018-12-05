package com.example.rebecca.p2_mobile.network

import com.example.rebecca.p2_mobile.entidades.DrinkList
import retrofit2.Call
import retrofit2.http.GET

interface DrinksService {

    @GET("1/random.php")
    fun getRandomCocktail() : Call<DrinkList>

    @GET("1/filter.php?a=Alcoholic")
    fun getAlcoholicCocktail() : Call<DrinkList>
}