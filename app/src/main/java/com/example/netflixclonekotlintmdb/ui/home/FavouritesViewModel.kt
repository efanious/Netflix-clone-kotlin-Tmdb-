package com.example.netflixclonekotlintmdb.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.example.netflixclonekotlintmdb.data.local.MovieDao
import com.example.netflixclonekotlintmdb.data.remote.response.Result
import com.example.netflixclonekotlintmdb.database.Movie
import com.example.netflixclonekotlintmdb.ui.moviedetail.MovieDetailViewModel
import kotlinx.coroutines.launch


class FavouritesViewModel(
    private val database: MovieDao,
    application: Application
) : AndroidViewModel(application) {

    private var _movies = MutableLiveData<List<Movie>>()

    val movie: LiveData<List<Movie>>
        get() = _movies

    init {
        //checkSizeOfMovies()
    }

    fun checkSizeOfMovies() {
        viewModelScope.launch {
            _movies.value = database.getAllFavourites()
        }
    }


}

class FavouritesViewModelFactory(
    private val dataSource: MovieDao,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavouritesViewModel::class.java)) {
            return FavouritesViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

