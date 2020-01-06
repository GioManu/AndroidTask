package com.cst.moviedb.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

import com.cst.moviedb.R
import com.cst.moviedb.data.MovieObject


class MovieInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_movie_info, container, false)

        val img : ImageView = v.findViewById(R.id.movie_image)
        val title : TextView = v.findViewById(R.id.movie_title)
        val date : TextView = v.findViewById(R.id.movie_date)
        val seasons : TextView = v.findViewById(R.id.movie_seasons)
        val lang : TextView = v.findViewById(R.id.movie_language)

        Glide.with(v.context).load(arguments!!.getString(ARG_MOVIE_IMG)).into(img)
        title.setText(arguments!!.getString(ARG_MOVIE_TITLE))
        date.setText(arguments!!.getString(ARG_MOVIE_DATE))
        seasons.setText(arguments!!.getString(ARG_MOVIE_SEASON))
        lang.setText(arguments!!.getString(ARG_MOVIE_LANG))

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    companion object {

        private val ARG_MOVIE_TITLE = "Movie_Title"
        private val ARG_MOVIE_DATE = "Movie_Date"
        private val ARG_MOVIE_IMG = "Movie_IMG"
        private val ARG_MOVIE_SEASON = "Movie_Seasons"
        private val ARG_MOVIE_LANG = "Movie_Lang"

        fun createInstance(movie : MovieObject): MovieInfoFragment {

            val fragment = MovieInfoFragment()

            val args = Bundle()

            args.putString(ARG_MOVIE_TITLE, movie.title)
            args.putString(ARG_MOVIE_DATE,movie.date)
            args.putString(ARG_MOVIE_IMG,movie.imageUrl)
            args.putString(ARG_MOVIE_SEASON,movie.seasons.toString())
            args.putString(ARG_MOVIE_LANG,movie.language)

            fragment.arguments = args

            return fragment
        }
    }

}


