package com.example.netflixclonekotlintmdb.repositories.impl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.netflixclonekotlintmdb.adapters.TopRatedPagingSource
import com.example.netflixclonekotlintmdb.data.remote.response.Result
import com.example.netflixclonekotlintmdb.data.remote.AppMainApi
import com.example.netflixclonekotlintmdb.data.remote.response.TrendingMoviesResponse
import com.example.netflixclonekotlintmdb.repositories.MovieListRepository
import kotlinx.coroutines.flow.Flow


class MovieListRepositoryImpl (private val moviesApi: AppMainApi) : MovieListRepository {

    override suspend fun getTrendingMovies(): TrendingMoviesResponse {
        return moviesApi.retrofitService.getTrendingMovies()
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun getTopRatedTVShowsStream(): Flow<PagingData<Result>> {
        return  Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { TopRatedPagingSource(moviesApi) }
        ).flow
    }

}