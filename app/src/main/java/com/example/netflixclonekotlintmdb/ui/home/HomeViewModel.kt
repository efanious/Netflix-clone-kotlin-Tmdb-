package com.example.netflixclonekotlintmdb.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.netflixclonekotlintmdb.data.remote.AppMainApi
import com.example.netflixclonekotlintmdb.data.remote.response.TrendingMoviesResponse
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel: ViewModel() {

    private val _response = MutableLiveData<TrendingMoviesResponse>()

    val response: LiveData<TrendingMoviesResponse>
        get() = _response

    private val _errorResponse = MutableLiveData<String>()

    val errorResponse: LiveData<String>
        get() = _errorResponse


    private val _errorTopRatedResponse = MutableLiveData<String>()

    val errorTopRatedResponse: LiveData<String>
        get() = _errorTopRatedResponse

    init {
    }

    fun getTrendingMovies() {

        viewModelScope.launch {
            try {

                _response.value = AppMainApi.retrofitService.getTrendingMovies()

            } catch (e: Exception) {

                _errorResponse.value = e.message

            }
        }
    }


    fun getTopRatedTVShows() {

        viewModelScope.launch {
            try {

                _response.value = AppMainApi.retrofitService.getTopRatedTV()

            } catch (e: Exception) {

                _errorTopRatedResponse.value = e.message

            }
        }
    }
}