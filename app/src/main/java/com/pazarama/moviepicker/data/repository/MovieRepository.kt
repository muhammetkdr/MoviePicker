package com.pazarama.moviepicker.data.repository

import com.pazarama.moviepicker.common.NetworkResponse
import com.pazarama.moviepicker.data.dto.Movies
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovieData() : Flow<NetworkResponse<Movies>>

}