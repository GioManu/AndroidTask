package com.cst.moviedb.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.cst.moviedb.R
import com.cst.moviedb.data.CastMemberObject
import com.cst.moviedb.movieCastRecycleView.MovieCastListAdapter
import com.cst.moviedb.movieRecycleView.MovieListAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MovieCastFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_cast_list, container, false)

        val rc = v.findViewById(R.id.cast_list_recycler) as RecyclerView

        val adapter = MovieCastListAdapter(arguments!!.getSerializable(ARG_CAST_LIST) as List<CastMemberObject>)
        rc.adapter = adapter
        rc.layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.VERTICAL, false)

        return v

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    companion object {
        private val ARG_CAST_LIST = "CAST_LIST"

        fun createInstance(cast : ArrayList<CastMemberObject>): MovieCastFragment {
            val fragment = MovieCastFragment()

            val bundle = Bundle()
            bundle.putSerializable(ARG_CAST_LIST,cast)
            fragment.arguments = bundle
            return fragment
        }
    }

}

