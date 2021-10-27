package com.phatherjay.anime.network


object AnimeRepo {
    private val animeService by lazy { RetrofitInstance.animeService }

    suspend fun fetchAnime(name: String) = animeService.getAnime(name)
}