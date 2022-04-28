package com.example.netflixclonekotlintmdb.ui.moviedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.netflixclonekotlintmdb.R
import com.example.netflixclonekotlintmdb.data.remote.response.Result

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movie: Result

    private lateinit var titleTextView: TextView
    private lateinit var backdropImageView: ImageView
    private lateinit var posterImageView: ImageView
    private lateinit var overviewTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        movie = intent.getParcelableExtra("Movie")!!

        titleTextView = findViewById(R.id.title_textview)
        backdropImageView = findViewById(R.id.backdropImageView)
        posterImageView = findViewById(R.id.posterImageView)
        overviewTextView = findViewById(R.id.overview_textview)


        displayInfo(movie)

        //Add trailer feature
    }

    private fun displayInfo(movie: Result) {

        titleTextView.text = movie.original_title ?: movie.original_name

        val fullBackDropPath = "https://image.tmdb.org/t/p/w500" + movie!!.backdrop_path
        Glide.with(this)
            .load(fullBackDropPath)
            .skipMemoryCache(true)
            .into(backdropImageView)

        val posterPath = "https://image.tmdb.org/t/p/w500" + movie!!.poster_path
        Glide.with(this)
            .load(posterPath)
            .skipMemoryCache(true)
            .into(posterImageView)

        overviewTextView.text = movie.overview

    }
}