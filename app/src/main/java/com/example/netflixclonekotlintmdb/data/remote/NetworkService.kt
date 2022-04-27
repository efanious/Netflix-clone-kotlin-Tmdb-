package com.example.netflixclonekotlintmdb.data.remote

import com.example.netflixclonekotlintmdb.BuildConfig
import com.example.netflixclonekotlintmdb.data.remote.response.TrendingMoviesResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org"

private const val API_KEY = ""


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val interceptor = HttpLoggingInterceptor()

val builder = OkHttpClient().newBuilder()
    .addInterceptor(interceptor.apply {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
    })
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(builder)
    .build()


interface NetworkService {


    @GET("/3/trending/{media_type}/{time_window}")
    suspend fun getTrendingMovies(
        @Path("media_type") mediaType: String = "all",
        @Path("time_window") timeWindow: String = "week",
        @Query("api_key") apiKey: String = API_KEY,
    ): TrendingMoviesResponse

    @GET("/3/tv/top_rated")
    suspend fun getTopRatedTV(
        @Query("api_key") apiKey: String = API_KEY
    ): TrendingMoviesResponse

}


object AppMainApi {
    val retrofitService: NetworkService by lazy {
        retrofit.create(NetworkService::class.java)

    }

}