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
import retrofit2.http.*

private const val BASE_URL = "https://api.themoviedb.org/3"
private const val API_KEY = "a42804cc4643c432ddbb2090891cb875"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val interceptor = HttpLoggingInterceptor()

val builder = OkHttpClient().newBuilder()
    .addInterceptor(interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY })
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(builder)

    .build()


interface NetworkService {

    @GET("/trending/all/week?api_key={API_KEY}&language=en-US")
    suspend fun getTrendingMovies(@Path("API_KEY") apiKey: String = API_KEY): TrendingMoviesResponse

}


object AppMainApi {
    val retrofitService : NetworkService by lazy {
        retrofit.create(NetworkService::class.java)

    }

}