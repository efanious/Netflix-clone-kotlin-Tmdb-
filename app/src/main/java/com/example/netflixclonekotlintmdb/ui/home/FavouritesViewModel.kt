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

    fun checkSizeOfMovies() {
        viewModelScope.launch {
            _movies.value = database.getAllFavourites()
        }
    }

    fun deleteMovieFromDb(item: Movie?) {
        viewModelScope.launch {
            database.deleteMovie(
                Movie(
                    adult = item?.adult,
                    backdropPath = item?.backdropPath,
                    id = item?.id,
                    originalLanguage = item?.originalLanguage,
                    originalTitle = item?.originalTitle,
                    overview = item?.overview,
                    posterPath = item?.posterPath,
                    releaseDate = item?.releaseDate,
                    title = item?.title,
                    video = item?.video,
                    voteAverage = item?.voteAverage,
                    voteCount = item?.voteCount,
                    popularity = item?.popularity,
                    originalName = item?.originalName,
                )
            )
        }

        checkSizeOfMovies()
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

