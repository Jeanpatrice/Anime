package com.phatherjay.anime.network

import retrofit2.Retrofit

object AnimeRepo {
    private val animeService by lazy { RetrofitInstance.animeService }

    suspend fun fetchAnime(name: String) = animeService.getAnime(name)
}