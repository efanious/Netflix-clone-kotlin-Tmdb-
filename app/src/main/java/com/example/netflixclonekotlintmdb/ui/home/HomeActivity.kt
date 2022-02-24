package com.example.netflixclonekotlintmdb.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.netflixclonekotlintmdb.R
import com.example.netflixclonekotlintmdb.data.remote.AppMainApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeActivity : AppCompatActivity() {

    private lateinit var testTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        testTextView = findViewById<TextView>(R.id.testTextView)

        lifecycleScope.launch {
            getMovies()
        }

    }


    private suspend fun getMovies() {
        coroutineScope {
            launch {
                try {

                    testTextView.text = AppMainApi.retrofitService.getTrendingMovies().toString()

                } catch (e: Exception) {

                    testTextView.text = e.message

                }
            }
        }

    }
}