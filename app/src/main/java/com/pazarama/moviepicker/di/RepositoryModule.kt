package com.pazarama.moviepicker.di

import com.pazarama.moviepicker.data.repository.MovieRepository
import com.pazarama.moviepicker.data.repository.MovieRepositoryImpl
import com.pazarama.moviepicker.data.source.MovieRemoteDataSource
import com.pazarama.moviepicker.data.source.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieRepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository

    @Binds
    @ViewModelScoped
    abstract fun bindMovieRemoteDataSource(movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl): MovieRemoteDataSource
}