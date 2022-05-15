package com.example.netflixclonekotlintmdb

import android.app.Application
import timber.log.Timber


class MovieGuideApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}