package com.pazarama.moviepicker.common

sealed class NetworkResponse<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResponse<T>()
    data class Error(val error: String) : NetworkResponse<Nothing>()
    data object Loading : NetworkResponse<Nothing>()
}