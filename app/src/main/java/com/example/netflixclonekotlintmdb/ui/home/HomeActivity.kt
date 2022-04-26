package com.example.netflixclonekotlintmdb.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.netflixclonekotlintmdb.R
import com.example.netflixclonekotlintmdb.data.remote.AppMainApi
import com.example.netflixclonekotlintmdb.data.remote.response.TrendingMoviesResponse
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeActivity : AppCompatActivity() {

    private lateinit var testTextView: TextView

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        testTextView = findViewById(R.id.testTextView)

        viewModel.response.observe(this, {
            testTextView.text = it.total_pages.toString()
        })

        viewModel.errorResponse.observe(this, {
            Toast.makeText(this, "ERROR :$it", Toast.LENGTH_LONG).show()
        })

    }


}