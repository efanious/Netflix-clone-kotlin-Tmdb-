package com.example.netflixclonekotlintmdb.data.remote

import com.example.netflixclonekotlintmdb.BuildConfig
import com.example.netflixclonekotlintmdb.data.remote.response.TrendingMoviesResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://api.themoviedb.org/3/"


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

    @GET("/trending/all/week?api_key=&language=en-US")
    suspend fun getTrendingMovies(): TrendingMoviesResponse


//@Path("API_KEY") apiKey: String = API_KEY)
}


object AppMainApi {
    val retrofitService: NetworkService by lazy {
        retrofit.create(NetworkService::class.java)

    }

}