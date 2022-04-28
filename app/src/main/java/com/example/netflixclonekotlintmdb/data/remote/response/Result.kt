package com.example.netflixclonekotlintmdb.data.remote.response

import android.os.Parcel
import android.os.Parcelable

data class Result(
    val adult : Boolean?,
    val backdrop_path : String?,
//    val genre_ids : List<Int>?,
    val id : Int?,
    val original_language : String?,
    val original_title : String?,
    val overview : String?,
    val poster_path : String?,
    val release_date : String?,
    val title : String?,
    val video : Boolean?,
    val vote_average : Double?,
    val vote_count : Int?,
    val popularity : Double?,
    val original_name : String?,

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(adult)
        parcel.writeString(backdrop_path)
        parcel.writeValue(id)
        parcel.writeString(original_language)
        parcel.writeString(original_title)
        parcel.writeString(overview)
        parcel.writeString(poster_path)
        parcel.writeString(release_date)
        parcel.writeString(title)
        parcel.writeValue(video)
        parcel.writeValue(vote_average)
        parcel.writeValue(vote_count)
        parcel.writeValue(popularity)
        parcel.writeString(original_name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Result> {
        override fun createFromParcel(parcel: Parcel): Result {
            return Result(parcel)
        }

        override fun newArray(size: Int): Array<Result?> {
            return arrayOfNulls(size)
        }
    }
}