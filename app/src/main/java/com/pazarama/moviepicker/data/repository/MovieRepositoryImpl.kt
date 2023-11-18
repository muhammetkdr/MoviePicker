package com.pazarama.moviepicker.data.repository

import com.pazarama.moviepicker.common.NetworkResponse
import com.pazarama.moviepicker.data.dto.MovieResponse
import com.pazarama.moviepicker.data.source.MovieRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieRepository {

    override suspend fun getMovieData(): Flow<NetworkResponse<MovieResponse>> {
        return movieRemoteDataSource.getMovieData()
    }


}

