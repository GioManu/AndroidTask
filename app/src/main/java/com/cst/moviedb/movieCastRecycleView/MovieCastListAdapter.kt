package com.cst.moviedb.movieCastRecycleView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cst.moviedb.R
import com.cst.moviedb.data.CastMemberObject


class MovieCastListAdapter(private val castList : List<CastMemberObject>) : RecyclerView.Adapter<MovieCastListViewHolder>() {

    override fun onBindViewHolder(holder: MovieCastListViewHolder, position: Int) {
        holder.setCastMember(castList[position])

    }

    override fun getItemCount(): Int {
        return castList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCastListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_cast_member, parent, false)
        return MovieCastListViewHolder(view)
    }
}