package com.phatherjay.anime.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AnimeData(
    @Json(name = "last_page")
    val lastPage: Int?,
    @Json(name = "request_cache_expiry")
    val requestCacheExpiry: Int?,
    @Json(name = "request_cached")
    val requestCached: Boolean?,
    @Json(name = "request_hash")
    val requestHash: String?,
    @Json(name = "results")
    val results: List<Result>?
)