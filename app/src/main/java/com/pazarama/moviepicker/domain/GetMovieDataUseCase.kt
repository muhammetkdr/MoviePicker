package com.pazarama.moviepicker.domain

import com.pazarama.moviepicker.data.repository.MovieRepository
import javax.inject.Inject

class GetMovieDataUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke() = movieRepository.getMovieData()
}
