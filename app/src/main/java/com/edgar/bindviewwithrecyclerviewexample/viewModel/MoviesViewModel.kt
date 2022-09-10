package com.edgar.bindviewwithrecyclerviewexample.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edgar.bindviewwithrecyclerviewexample.model.Movie

class MoviesViewModel: ViewModel() {
    private val movies: MutableList<Movie> = mutableListOf()

    fun getMovies(): MutableList<Movie> {
        return movies;
    }

    fun addMovie(movie: Movie){
        movies.add(movie)
    }

}