package com.cst.moviedb.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movies (
    @SerializedName("movies") val movies : ArrayList<MovieObject>
) : Serializable