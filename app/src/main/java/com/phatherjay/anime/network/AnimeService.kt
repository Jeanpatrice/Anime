package com.phatherjay.anime.network

import com.phatherjay.anime.model.AnimeData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeService {
    @GET("v3/search/anime")
    suspend fun getAnime(@Query("q")q :String):Response<AnimeData>
}