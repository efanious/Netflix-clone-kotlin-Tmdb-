package com.example.netflixclonekotlintmdb.repositories.impl

import com.example.netflixclonekotlintmdb.data.remote.AppMainApi
import com.example.netflixclonekotlintmdb.data.remote.response.TrendingMoviesResponse
import com.example.netflixclonekotlintmdb.repositories.MovieListRepository


class MovieListRepositoryImpl (private val moviesApi: AppMainApi) : MovieListRepository {

    override suspend fun getTrendingMovies(): TrendingMoviesResponse {
        return moviesApi.retrofitService.getTrendingMovies()
    }

    override suspend fun getTopRatedTVShows(): TrendingMoviesResponse {
        return moviesApi.retrofitService.getTopRatedTV()
    }

}