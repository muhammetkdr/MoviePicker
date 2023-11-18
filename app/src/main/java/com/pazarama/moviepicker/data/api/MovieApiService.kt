package com.pazarama.moviepicker.data.api

import com.pazarama.moviepicker.BuildConfig
import com.pazarama.moviepicker.data.dto.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("?s=fast")
    suspend fun getMovieList(
//        @Query("s") searchTitle : String = "batman",
        @Query("page") page: Int = 1,
        @Query("apikey") apiKey: String = BuildConfig.API_KEY
    ) : Response<MovieResponse>

}