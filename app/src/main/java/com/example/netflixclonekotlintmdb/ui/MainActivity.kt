package com.example.netflixclonekotlintmdb.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.netflixclonekotlintmdb.R
import com.example.netflixclonekotlintmdb.ui.home.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guestButton = findViewById<Button>(R.id.guestButton)


        guestButton.setOnClickListener {
            val intent = Intent(
                this,
                HomeActivity::class.java
            )
            startActivity(intent)

            // Dispatchers.Main
        }
    }

}