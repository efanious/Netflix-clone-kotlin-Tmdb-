package com.example.netflixclonekotlintmdb.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.netflixclonekotlintmdb.R
import com.example.netflixclonekotlintmdb.database.Movie


class FavouritesAdapter : RecyclerView.Adapter<FavouritesAdapter.FavouritesViewHolder>() {

    var data = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.favourite_item_view, parent, false)
        return FavouritesViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: FavouritesViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size


    class FavouritesViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val titleText: TextView = itemView.findViewById(R.id.faveTitleTextView)
        private val posterPath: ImageView = itemView.findViewById(R.id.favImageView)

        private var movie: Movie? = null
//
//        init {
//            itemView.setOnClickListener {
//                movie?.let {
//                    onClick(it)
//                }
//            }
//        }
//
//        private fun onClick(movieClicked: Result) {
//
//            val intent = Intent(itemView.context, MovieDetailActivity::class.java)
//            intent.putExtra("Movie", movieClicked)
//            itemView.context.startActivity(intent)
//
//        }
//
        fun bind(mMovie: Movie) {
            movie = mMovie

            titleText.text = movie!!.originalTitle ?: movie!!.originalName
            val fullPosterPath = "https://image.tmdb.org/t/p/w500" + movie!!.posterPath

            Glide.with(itemView.context)
                .load(fullPosterPath)
                .skipMemoryCache(true)
                .into(posterPath)

        }
    }


}