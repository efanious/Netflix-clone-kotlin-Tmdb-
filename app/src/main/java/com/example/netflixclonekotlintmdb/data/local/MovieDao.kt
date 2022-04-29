package com.example.netflixclonekotlintmdb.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.netflixclonekotlintmdb.database.Movie

@Dao
interface MovieDao {

    @Insert
    suspend fun insert(movie: Movie)

    @Delete
    suspend fun deleteMovie(movie: Movie)

    @Query("DELETE FROM fav_movies_table")
    suspend fun deleteAllFavourites()

    @Query("SELECT * FROM  fav_movies_table ")
    suspend fun getAllFavourites(): List<Movie>

    @Query("SELECT * FROM fav_movies_table WHERE id = :movieId")
    suspend fun getMovie(movieId: Int): Movie?
}
