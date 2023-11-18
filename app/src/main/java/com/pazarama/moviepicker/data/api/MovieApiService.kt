package com.pazarama.moviepicker.data.api

import com.pazarama.moviepicker.BuildConfig
import com.pazarama.moviepicker.data.dto.moviedata.Movies
import com.pazarama.moviepicker.data.dto.search.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("?s=fast")
    suspend fun getMovieList(
        @Query("page") page: Int = 1,
        @Query("apikey") apiKey: String = BuildConfig.API_KEY
    ): Response<Movies>

    @GET("")
    suspend fun getMovieById(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey: String = BuildConfig.API_KEY
    ): Response<SearchResponse>

}