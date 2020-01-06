package com.cst.moviedb.movieRecycleView

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cst.moviedb.MainActivity
import com.cst.moviedb.R
import com.cst.moviedb.SecondActivity
import com.cst.moviedb.data.MovieObject

class MovieListViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val titleTextView = view.findViewById<TextView>(R.id.movie_title)
    private val imageView = view.findViewById<ImageView>(R.id.movie_image)

    fun setMovie(movie: MovieObject) {
        // Insert into fragment
        titleTextView.text = movie.title

        if(!movie.imageUrl.isNullOrEmpty()) {
            Glide.with(itemView.context).load(movie.imageUrl).into(imageView)
        }else {
            Glide.with(itemView.context).load("https://a-static.besthdwallpaper.com/deadpool-chaos-in-the-city-wallpaper-1280x1024-11748_32.jpg").into(imageView)
        }

        itemView.setOnClickListener {

            val intent = Intent(it.context,SecondActivity::class.java)
            intent.putExtra("Movie",movie)

            it.context.startActivity(intent)
        }
    }

}