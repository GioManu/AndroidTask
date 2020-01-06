package com.cst.moviedb.movieRecycleView

import android.app.PendingIntent.getActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cst.moviedb.R
import com.cst.moviedb.data.MovieObject


class MovieListAdapter(private val movieList : List<MovieObject>) : RecyclerView.Adapter<MovieListViewHolder>() {

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.setMovie(movieList[position])

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_card, parent, false)
        return MovieListViewHolder(view)
    }
}