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


class TrendingFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_trending, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val trendingRView: RecyclerView = view.findViewById(R.id.trending_recycler_view)
        trendingRView.layoutManager =
            GridLayoutManager(this.context, 2)

        val trendingMoviesAdapter = MoviesAdapter()


        viewModel.getTrendingMovies()

        viewModel.response.observe(this, {

            trendingMoviesAdapter.data = it.results!!
            trendingRView.adapter = trendingMoviesAdapter

        })

        viewModel.errorResponse.observe(this, {
            Toast.makeText(this.context, "ERROR :$it", Toast.LENGTH_LONG).show()
        })

    }

}