package com.pazarama.moviepicker.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pazarama.moviepicker.common.NetworkResponse
import com.pazarama.moviepicker.data.dto.search.SearchResponse
import com.pazarama.moviepicker.domain.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase) :
    ViewModel() {

    private val _movieDetails = MutableLiveData<NetworkResponse<SearchResponse>>()
    val movieDetails: LiveData<NetworkResponse<SearchResponse>> = _movieDetails

    fun getMovieDetails(id:String) {
        viewModelScope.launch(Dispatchers.IO) {
            getMovieDetailUseCase.invoke(id= id).collect{
                _movieDetails.postValue(it)
            }
        }
    }

}