package com.pazarama.moviepicker.domain

import com.pazarama.moviepicker.data.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(id:String) = movieRepository.getMovieById(id= id)
}
