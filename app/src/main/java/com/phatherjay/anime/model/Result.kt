package com.phatherjay.anime.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "airing")
    val airing: Boolean?,
    @Json(name = "end_date")
    val endDate: String?,
    @Json(name = "episodes")
    val episodes: Int?,
    @Json(name = "image_url")
    val imageUrl: String?,
    @Json(name = "mal_id")
    val malId: Int?,
    @Json(name = "members")
    val members: Int?,
    @Json(name = "rated")
    val rated: String?,
    @Json(name = "score")
    val score: Double?,
    @Json(name = "start_date")
    val startDate: String?,
    @Json(name = "synopsis")
    val synopsis: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "url")
    val url: String?
)