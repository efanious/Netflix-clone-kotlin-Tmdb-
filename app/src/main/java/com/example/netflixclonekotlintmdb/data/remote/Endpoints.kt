package com.example.netflixclonekotlintmdb.data.remote

import com.example.netflixclonekotlintmdb.data.remote.Networking.API_KEY

object Endpoints {
    const val DUMMY = "dummy/list"
    const val LOGIN = "login/mindorks"
    var FETCHTRENDING = "/trending/all/week?api_key=${API_KEY}&language=en-US"
}