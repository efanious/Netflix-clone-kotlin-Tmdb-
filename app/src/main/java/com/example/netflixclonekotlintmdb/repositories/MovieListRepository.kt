package com.example.netflixclonekotlintmdb.repositories

import com.example.netflixclonekotlintmdb.data.remote.response.TrendingMoviesResponse

/**
 * Note: typically an app would implement a repo once, either
 * network+db, or network-only
 */

interface MovieListRepository {

    suspend fun getTrendingMovies(): TrendingMoviesResponse

    suspend fun getTopRatedTVShows(): TrendingMoviesResponse
}


