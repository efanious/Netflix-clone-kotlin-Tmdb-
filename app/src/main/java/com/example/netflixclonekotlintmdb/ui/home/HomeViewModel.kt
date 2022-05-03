package com.example.netflixclonekotlintmdb.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.netflixclonekotlintmdb.data.remote.AppMainApi
import com.example.netflixclonekotlintmdb.data.remote.response.TrendingMoviesResponse
import com.example.netflixclonekotlintmdb.repositories.impl.MovieListRepositoryImpl
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel: ViewModel() {

    private val movieListRepository = MovieListRepositoryImpl(AppMainApi)

    private val _response = MutableLiveData<TrendingMoviesResponse>()

    val response: LiveData<TrendingMoviesResponse>
        get() = _response

    private val _errorResponse = MutableLiveData<String>()

    val errorResponse: LiveData<String>
        get() = _errorResponse


    private val _errorTopRatedResponse = MutableLiveData<String>()

    val errorTopRatedResponse: LiveData<String>
        get() = _errorTopRatedResponse


    private var _eventNetworkError = MutableLiveData<Boolean>(false)
    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    init {
    }

    fun getTrendingMovies() {

        viewModelScope.launch {
            try {
                _eventNetworkError.value = false
                _response.value = movieListRepository.getTrendingMovies()

            } catch (e: Exception) {
                _eventNetworkError.value = true
                _errorResponse.value = e.message

            }
        }
    }


    fun getTopRatedTVShows() {

        viewModelScope.launch {
            try {
                _eventNetworkError.value = false
                _response.value = movieListRepository.getTopRatedTVShows()

            } catch (e: Exception) {

                _eventNetworkError.value = true
                _errorTopRatedResponse.value = e.message

            }
        }
    }
}