package com.example.netflixclonekotlintmdb.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixclonekotlintmdb.R
import com.example.netflixclonekotlintmdb.adapters.FavouritesAdapter
import com.example.netflixclonekotlintmdb.database.AppDatabase


class FavouritesFragment : Fragment() {

    private lateinit var emptyLayout: LinearLayout

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

        val favouritesRView: RecyclerView = view.findViewById(R.id.favourites_rv)
        favouritesRView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        val favAdapter = FavouritesAdapter()

        emptyLayout = view.findViewById(R.id.emptyListLayout)

        viewModel.checkSizeOfMovies()

        viewModel.movie.observe(this, {

            if(it.isEmpty()){
                emptyLayout.visibility = View.VISIBLE
                favouritesRView.visibility = View.GONE
            } else {
                emptyLayout.visibility = View.GONE
                favouritesRView.visibility = View.VISIBLE
                favAdapter.data = it
                favouritesRView.adapter = favAdapter

            }
        })

    }



}