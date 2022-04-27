package com.example.netflixclonekotlintmdb.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.netflixclonekotlintmdb.R


class TrendingFragment : Fragment() {

    private lateinit var testTextView: TextView

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

        //For testing purposes
        testTextView = view.findViewById(R.id.testCallForTrending)

        viewModel.getTrendingMovies()

        viewModel.response.observe(this, {
            testTextView.text = it.total_pages.toString()
        })

        viewModel.errorResponse.observe(this, {
            Toast.makeText(this.context, "ERROR :$it", Toast.LENGTH_LONG).show()
        })

    }

}