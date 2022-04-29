package com.example.netflixclonekotlintmdb.ui.moviedetail

import android.app.Application
import android.text.TextUtils
import androidx.arch.core.util.Function
import androidx.lifecycle.*
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.netflixclonekotlintmdb.data.local.MovieDao
import com.example.netflixclonekotlintmdb.data.remote.response.Result
import com.example.netflixclonekotlintmdb.database.Movie
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val database: MovieDao,
    application: Application,
    private val movie: Result
) : AndroidViewModel(application) {

    fun addOrRemoveAsFav() {
        viewModelScope.launch {
            database.insert(
                Movie(
                    adult = movie.adult,
                    backdropPath = movie.backdrop_path,
                    id = movie.id,
                    originalLanguage = movie.original_language,
                    originalTitle = movie.original_title,
                    overview = movie.overview,
                    posterPath = movie.poster_path,
                    releaseDate = movie.release_date,
                    title = movie.title,
                    video = movie.video,
                    voteAverage = movie.vote_average,
                    voteCount = movie.vote_count,
                    popularity = movie.popularity,
                    originalName = movie.original_name,
                )
            )
        }

    }

}

class MovieDetailViewModelFactory(
    private val dataSource: MovieDao,
    private val application: Application,
    private val movie: Result
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieDetailViewModel::class.java)) {
            return MovieDetailViewModel(dataSource, application, movie) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
