package com.pazarama.moviepicker.data.source

import com.pazarama.moviepicker.common.NetworkResponse
import com.pazarama.moviepicker.data.dto.moviedata.Movies
import com.pazarama.moviepicker.data.dto.search.SearchResponse
import kotlinx.coroutines.flow.Flow

interface MovieRemoteDataSource {
    suspend fun getMovieData(query:String): Flow<NetworkResponse<Movies>>
    suspend fun getMovieById(id:String): Flow<NetworkResponse<SearchResponse>>
}