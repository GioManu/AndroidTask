package com.cst.moviedb.fragment

import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cst.moviedb.R

class MovieListCardFragment : Fragment() {
    private lateinit var frgmt: Layout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_card, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        fun createInstance(text: String): MovieListCardFragment {
            val fragment = MovieListCardFragment()
            val bundle = Bundle()
            return fragment
        }
    }

}