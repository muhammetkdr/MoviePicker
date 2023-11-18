package com.pazarama.moviepicker.data.source

import com.pazarama.moviepicker.common.NetworkResponse
import com.pazarama.moviepicker.data.dto.Movies
import kotlinx.coroutines.flow.Flow

interface MovieRemoteDataSource {
    suspend fun getMovieData(): Flow<NetworkResponse<Movies>>
}