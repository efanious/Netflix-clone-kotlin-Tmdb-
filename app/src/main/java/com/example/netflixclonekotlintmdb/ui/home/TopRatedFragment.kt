package com.example.netflixclonekotlintmdb.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixclonekotlintmdb.R
import com.example.netflixclonekotlintmdb.adapters.TopRatedPagingAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class TopRatedFragment : Fragment() {

    private lateinit var progressLoading: ProgressBar
    private lateinit var errorLayoutLL: LinearLayout
    private lateinit var errorTextView: TextView

    private val adapter = TopRatedPagingAdapter()

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_rated, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressLoading = view.findViewById(R.id.loading_spinner)
        errorLayoutLL = view.findViewById(R.id.errorLayout)
        errorTextView = view.findViewById(R.id.errorText)

        val topRatedView: RecyclerView = view.findViewById(R.id.topRatedRV)
        topRatedView.layoutManager =
            GridLayoutManager(this.context, 2)

        topRatedView.adapter = adapter

        progressLoading.visibility = View.VISIBLE
        errorLayoutLL.visibility = View.GONE

        lifecycleScope.launch {

            viewModel.getTopRatedTVShows().collect {
                item -> adapter.submitData(item)

                topRatedView.adapter = adapter
            }

        }


        viewModel.eventNetworkError.observe(this, { isNetworkError ->
            if (isNetworkError) {
                progressLoading.visibility = View.GONE
                errorLayoutLL.visibility = View.VISIBLE
            } else {
                progressLoading.visibility = View.GONE
                errorLayoutLL.visibility = View.GONE
            }
        })

    }


//    private fun showError(error: String? = "Error getting lists") {
//        //errorLayoutLL.visibility = View.VISIBLE
//        errorTextView.text = error
//
//    }

}