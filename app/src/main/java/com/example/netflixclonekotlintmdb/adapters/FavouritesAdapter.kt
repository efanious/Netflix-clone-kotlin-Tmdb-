package com.example.netflixclonekotlintmdb.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.netflixclonekotlintmdb.R
import com.example.netflixclonekotlintmdb.database.Movie
import kotlinx.coroutines.launch


class FavouritesAdapter(listener : OnItemClickListener ) : RecyclerView.Adapter<FavouritesAdapter.FavouritesViewHolder>() {

    var data = listOf<Movie>()

    var mListener = listener

    interface OnItemClickListener {
        fun onItemClick(item: Movie?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.favourite_item_view, parent, false)
        return FavouritesViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: FavouritesViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, mListener)
    }

    override fun getItemCount() = data.size


    class FavouritesViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val titleText: TextView = itemView.findViewById(R.id.faveTitleTextView)
        private val posterPath: ImageView = itemView.findViewById(R.id.favImageView)
        private val removeGroupLayout: LinearLayout = itemView.findViewById(R.id.removeLayout)

        private var movie: Movie? = null

//        init {
//            removeGroupLayout.setOnClickListener {
//                movie?.let {
//                    onClick(it)
//                }
//            }
//        }

//        private fun onClick(movieClicked: Movie) {
//            onItemClicked

////            )
//
//        }

        fun bind(mMovie: Movie, listener:  OnItemClickListener ) {
            movie = mMovie

            titleText.text = movie!!.originalTitle ?: movie!!.originalName
            val fullPosterPath = "https://image.tmdb.org/t/p/w500" + movie!!.posterPath

            Glide.with(itemView.context)
                .load(fullPosterPath)
                .skipMemoryCache(true)
                .into(posterPath)

            removeGroupLayout.setOnClickListener {
                movie?.let {
                    listener.onItemClick(movie)
                }
            }

        }
    }


}