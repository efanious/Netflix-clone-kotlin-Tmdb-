package com.example.netflixclonekotlintmdb.repositories

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.example.netflixclonekotlintmdb.data.remote.response.Result
import com.example.netflixclonekotlintmdb.data.remote.response.TrendingMoviesResponse
import kotlinx.coroutines.flow.Flow

/**
 * Note: typically an app would implement a repo once, either
 * network+db, or network-only
 */

interface MovieListRepository {

    suspend fun getTrendingMovies(): TrendingMoviesResponse

    @OptIn(ExperimentalPagingApi::class)
    fun getTopRatedTVShowsStream(): Flow<PagingData<Result>>
}


