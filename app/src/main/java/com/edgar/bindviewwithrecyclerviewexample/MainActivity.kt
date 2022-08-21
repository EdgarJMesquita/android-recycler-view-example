package com.edgar.bindviewwithrecyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.edgar.bindviewwithrecyclerviewexample.databinding.ActivityMainBinding
import com.edgar.bindviewwithrecyclerviewexample.model.Movie
import com.edgar.bindviewwithrecyclerviewexample.movies_adapter.MoviesListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val movies: MutableList<Movie> = mutableListOf()

    private lateinit var moviesListAdapter: MoviesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerViewMoviesList = binding.recyclerViewMovies
        recyclerViewMoviesList.layoutManager = LinearLayoutManager(this)
        moviesListAdapter = MoviesListAdapter(this, movies)
        recyclerViewMoviesList.adapter = moviesListAdapter

        generateData()

        binding.button.setOnClickListener {
            val newMovie = Movie(binding.editTextMovie.text.toString())
            moviesListAdapter.addMovie(newMovie)
        }
    }

    private fun generateData (){
        movies.add(Movie("As Aventuras de PI"))

    }
}