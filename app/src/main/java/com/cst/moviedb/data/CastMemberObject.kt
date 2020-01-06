package com.cst.moviedb.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CastMemberObject (
    @SerializedName("id") val id : Int,
    @SerializedName("fullName") val fullName : String,
    @SerializedName("role") val role : String,
    @SerializedName("imageUrl") val imageUrl : String
) : Serializable