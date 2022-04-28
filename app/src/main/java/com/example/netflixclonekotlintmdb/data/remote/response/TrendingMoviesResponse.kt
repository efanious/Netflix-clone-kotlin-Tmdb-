package com.example.netflixclonekotlintmdb.data.remote.response

import android.os.Parcel
import android.os.Parcelable

data class TrendingMoviesResponse(

    val page : Int?,
    val results : List<Result>?,
    val total_pages : Int?,
    val total_results : Int?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.createTypedArrayList(Result),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(page)
        parcel.writeTypedList(results)
        parcel.writeValue(total_pages)
        parcel.writeValue(total_results)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TrendingMoviesResponse> {
        override fun createFromParcel(parcel: Parcel): TrendingMoviesResponse {
            return TrendingMoviesResponse(parcel)
        }

        override fun newArray(size: Int): Array<TrendingMoviesResponse?> {
            return arrayOfNulls(size)
        }
    }
}
