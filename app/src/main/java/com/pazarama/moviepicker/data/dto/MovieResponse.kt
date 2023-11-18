package com.pazarama.moviepicker.data.dto

import com.squareup.moshi.Json

data class MovieResponse(
    @Json(name = "Response")
    val response: String?,
    @Json(name = "Search")
    val search: List<Search?>,
    @Json(name = "totalResults")
    val totalResults: String?
)