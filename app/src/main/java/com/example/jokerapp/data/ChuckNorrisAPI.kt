package com.example.jokerapp.data

import com.example.jokerapp.model.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisAPI {

    @GET("jokes/categories")
    fun findAllCategories(@Query("apiKey")apiKey: String = HTTPClient.API_KEY): Call<List<String>>

    @GET("jokes/random")
    fun findRandom(@Query("category")categoryName: String? = null, @Query("apiKey") apiKey: String = HTTPClient.API_KEY) : Call <Joke>
}