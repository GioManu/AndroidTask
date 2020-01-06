package com.cst.moviedb

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.cst.moviedb.data.MovieObject
import com.cst.moviedb.fragment.MovieCastFragment
import com.cst.moviedb.fragment.MovieInfoFragment
import com.cst.moviedb.viewPager.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class SecondActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val movie = this.intent.getSerializableExtra("Movie") as MovieObject

        viewPager = findViewById(R.id.view_pager)
        tabLayout  = findViewById(R.id.tabs)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        viewPagerAdapter.addFragment(MovieInfoFragment.createInstance(movie),"INFO")
        viewPagerAdapter.addFragment(MovieCastFragment.createInstance(movie.cast),"CAST")

        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)

    }

}