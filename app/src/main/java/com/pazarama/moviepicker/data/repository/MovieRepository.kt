package com.pazarama.moviepicker.data.repository

import com.pazarama.moviepicker.common.NetworkResponse
import com.pazarama.moviepicker.data.dto.moviedata.Movies
import com.pazarama.moviepicker.data.dto.search.SearchResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovieData() : Flow<NetworkResponse<Movies>>
    suspend fun getMovieById(id:String): Flow<NetworkResponse<SearchResponse>>

}