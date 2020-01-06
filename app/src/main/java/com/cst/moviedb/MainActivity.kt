package com.cst.moviedb

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.cst.moviedb.data.Movies
import com.cst.moviedb.movieRecycleView.MovieListAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL


class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        val movFromAPI = MoviesFromAPI()
        movFromAPI.execute("https://my-json-server.typicode.com/nikoloz14/movies-db/db")

    }

    inner class MoviesFromAPI() : AsyncTask<String, Any, String>() {

        override fun doInBackground(vararg params: String?): String {
            runOnUiThread {
                progressBar.visibility = VISIBLE
            }
            val url = URL(params[0])
            val urlConnection = url.openConnection()

            val stream = BufferedInputStream(urlConnection.inputStream)
            val bufferedReader = BufferedReader(InputStreamReader(stream))
            val builder = StringBuilder()

            var chunk = bufferedReader.readLine()
            while (chunk != null) {
                builder.append(chunk)
                chunk = bufferedReader.readLine()
            }

            return builder.toString()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            result?.let {
                val gson = Gson()
                try {
                    val objs = gson.fromJson(it, Movies::class.java)

                    val adapter = MovieListAdapter(objs.movies)
                    recyclerView.adapter = adapter
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

                }catch(e:Exception) {
                    print(e.message)
                }

            }

            progressBar.visibility = GONE
        }
    }

}
