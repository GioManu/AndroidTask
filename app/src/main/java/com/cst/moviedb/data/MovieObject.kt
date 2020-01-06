package com.cst.moviedb.data
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieObject (

    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("date") val date : String,
    @SerializedName("language") val language : String,
    @SerializedName("seasons") val seasons : Int,
    @SerializedName("cast") val cast : ArrayList<CastMemberObject>,
    @SerializedName("imageUrl") val imageUrl : String
) : Serializable