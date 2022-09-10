package com.edgar.bindviewwithrecyclerviewexample.movies_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edgar.bindviewwithrecyclerviewexample.databinding.MovieCardBinding
import com.edgar.bindviewwithrecyclerviewexample.model.Movie

class MoviesListAdapter(private val context: Context, private var movies: MutableList<Movie>) :
    RecyclerView.Adapter<MoviesListAdapter.MovieViewHolder>() {

    class MovieViewHolder(binding: MovieCardBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        val textViewTitle = binding.textViewTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        var listItem = MovieCardBinding.inflate(LayoutInflater.from(context),parent, false)
        return MovieViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val current = movies[position]
        holder.textViewTitle.text = current.title
    }

    override fun getItemCount(): Int = movies.size

    fun addMovie(movie:Movie){
        movies.add(movie)
        notifyItemInserted(movies.size-1)
    }

}