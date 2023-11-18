package com.pazarama.moviepicker.data.repository

import com.pazarama.moviepicker.common.NetworkResponse
import com.pazarama.moviepicker.data.dto.moviedata.Movies
import com.pazarama.moviepicker.data.dto.search.SearchResponse
import com.pazarama.moviepicker.data.source.MovieRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieRepository {

    override suspend fun getMovieData(query:String): Flow<NetworkResponse<Movies>> {
        return movieRemoteDataSource.getMovieData(query= query)
    }

    override suspend fun getMovieById(id: String): Flow<NetworkResponse<SearchResponse>> {
        return movieRemoteDataSource.getMovieById(id)
    }


}

