package com.example.netflixclonekotlintmdb.ui.moviedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.netflixclonekotlintmdb.R
import com.example.netflixclonekotlintmdb.data.remote.response.Result
import com.example.netflixclonekotlintmdb.database.AppDatabase

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movie: Result


    private lateinit var titleTextView: TextView
    private lateinit var backdropImageView: ImageView
    private lateinit var posterImageView: ImageView
    private lateinit var overviewTextView: TextView
    private lateinit var favButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        movie = intent.getParcelableExtra("Movie")!!

        val application = requireNotNull(this).application

        val dataSource = AppDatabase.getInstance(application).movieDatabaseDao

        val viewModelFactory = MovieDetailViewModelFactory(dataSource, application, movie)

        val viewModel = ViewModelProvider(this, viewModelFactory)[MovieDetailViewModel::class.java]

        titleTextView = findViewById(R.id.title_textview)
        backdropImageView = findViewById(R.id.backdropImageView)
        posterImageView = findViewById(R.id.posterImageView)
        overviewTextView = findViewById(R.id.overview_textview)

        favButton = findViewById(R.id.favourite_button)

        displayInfo(movie)

        viewModel.movInDb.observe(this) {
            if (it) {
                favButton.text = getString(R.string.remove_as_fav)
            } else {
                favButton.text = getString(R.string.add_as_fav)
            }
        }

        favButton.setOnClickListener {
            viewModel.addOrRemoveAsFav()
        }

        //Add trailer feature
    }


    private fun displayInfo(movie: Result) {

        titleTextView.text = movie.original_title ?: movie.original_name

        val fullBackDropPath = "https://image.tmdb.org/t/p/w500" + movie.backdrop_path
        Glide.with(this)
            .load(fullBackDropPath)
            .skipMemoryCache(true)
            .into(backdropImageView)

        val posterPath = "https://image.tmdb.org/t/p/w500" + movie.poster_path
        Glide.with(this)
            .load(posterPath)
            .skipMemoryCache(true)
            .into(posterImageView)

        overviewTextView.text = movie.overview

    }
}