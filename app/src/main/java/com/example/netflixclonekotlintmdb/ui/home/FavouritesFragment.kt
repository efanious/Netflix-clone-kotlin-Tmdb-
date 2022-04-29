package com.example.netflixclonekotlintmdb.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixclonekotlintmdb.R
import com.example.netflixclonekotlintmdb.adapters.MoviesAdapter
import com.example.netflixclonekotlintmdb.database.AppDatabase
import com.example.netflixclonekotlintmdb.ui.moviedetail.MovieDetailViewModel
import com.example.netflixclonekotlintmdb.ui.moviedetail.MovieDetailViewModelFactory


class FavouritesFragment : Fragment() {

    private lateinit var favSizeTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val application = requireNotNull(this).requireActivity().application
        val dataSource = AppDatabase.getInstance(application).movieDatabaseDao
        val viewModelFactory = FavouritesViewModelFactory(dataSource, application)
        val viewModel = ViewModelProvider(this, viewModelFactory)[FavouritesViewModel::class.java]

        favSizeTextView = view.findViewById(R.id.sizeOfFavList)

        viewModel.checkSizeOfMovies()

        viewModel.movie.observe(this, {

            favSizeTextView.text = "List of favs is:  ${it.size}"
            Toast.makeText(activity, "List of favs is:  ${it.size}", Toast.LENGTH_LONG).show()
        })

    }



}