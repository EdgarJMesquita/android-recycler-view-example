package com.edgar.bindviewwithrecyclerviewexample

import android.hardware.input.InputManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.edgar.bindviewwithrecyclerviewexample.databinding.ActivityMainBinding
import com.edgar.bindviewwithrecyclerviewexample.model.Movie
import com.edgar.bindviewwithrecyclerviewexample.movies_adapter.MoviesListAdapter
import com.edgar.bindviewwithrecyclerviewexample.viewModel.MoviesViewModel
import com.edgar.bindviewwithrecyclerviewexample.viewModel.MoviesViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel by lazy {
        ViewModelProvider(this, MoviesViewModelFactory()).get(MoviesViewModel::class.java)
    }
    private lateinit var moviesListAdapter: MoviesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadRecyclerView(viewModel.getMovies())

        binding.button.setOnClickListener {
            val newMovie = Movie(binding.editTextMovie.text.toString())
            moviesListAdapter.addMovie(newMovie)
            binding.editTextMovie.text.clear()
            hideKeyboard()
        }
    }

    private fun loadRecyclerView(movies: MutableList<Movie>) {
        val recyclerViewMoviesList = binding.recyclerViewMovies
        recyclerViewMoviesList.layoutManager = LinearLayoutManager(this)
        moviesListAdapter = MoviesListAdapter(this,movies)
        recyclerViewMoviesList.adapter = moviesListAdapter
    }

    private fun hideKeyboard(){
        val view = this.currentFocus
        if(view !=null ) {
            val inputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}