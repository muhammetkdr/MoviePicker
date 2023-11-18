package com.pazarama.moviepicker.data.source

import com.pazarama.moviepicker.common.NetworkResponse
import com.pazarama.moviepicker.data.api.MovieApiService
import com.pazarama.moviepicker.data.dto.MovieResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(private val apiService:MovieApiService): MovieRemoteDataSource {

    override suspend fun getMovieData(): Flow<NetworkResponse<MovieResponse>> = flow {
        emit(NetworkResponse.Loading)
        val response = apiService.getMovieList()
        if (response.isSuccessful){
            response.body()?.let {
            emit(NetworkResponse.Success(it))
            } ?: emit(NetworkResponse.Error(NETWORK_ERROR))
        }else{
            emit(NetworkResponse.Error(NETWORK_ERROR))
        }
    }.catch {
        emit(NetworkResponse.Error(it.message ?: NETWORK_ERROR))
    }

    companion object{
        const val NETWORK_ERROR= "No Data!"
    }
}