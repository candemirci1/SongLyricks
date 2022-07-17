package com.example.songlyricks.data.serivce

import com.example.songlyricks.BuildConfig
import com.example.songlyricks.data.model.SearchDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GeniusService {
    @GET("search")
    suspend fun fetchSearch(
        @Query("q") q : String,
        @Header("X-RapidAPI-Key") apiKey : String = BuildConfig.API_KEY,
        @Header("X-RapidAPI-Host") rapidApi: String = "genius.p.rapidapi.com"
    ) : SearchDTO
}