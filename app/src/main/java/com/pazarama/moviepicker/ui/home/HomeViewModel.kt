package com.pazarama.moviepicker.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pazarama.moviepicker.common.NetworkResponse
import com.pazarama.moviepicker.data.dto.Movies
import com.pazarama.moviepicker.domain.GetMovieDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieDataUseCase: GetMovieDataUseCase) : ViewModel()  {

    private val _movieData = MutableLiveData<NetworkResponse<Movies>>()
    val movieData : LiveData<NetworkResponse<Movies>> = _movieData

    fun getMovieData() = viewModelScope.launch(Dispatchers.IO) {
        movieDataUseCase.invoke().collect{
            _movieData.postValue(it)
        }
    }

}