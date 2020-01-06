package com.cst.moviedb.movieCastRecycleView

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cst.moviedb.R
import com.cst.moviedb.data.CastMemberObject

class MovieCastListViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val actorName = view.findViewById<TextView>(R.id.cast_member_actor_name)
    private val name = view.findViewById<TextView>(R.id.cast_member_name)
    private val imageView = view.findViewById<ImageView>(R.id.cast_member_image)

    fun setCastMember(castMember: CastMemberObject) {
        actorName.text = castMember.fullName
        name.text = castMember.role

        Glide.with(itemView.context).load(castMember.imageUrl).into(imageView)
    }

}