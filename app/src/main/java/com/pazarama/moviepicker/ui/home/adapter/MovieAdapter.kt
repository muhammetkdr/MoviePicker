package com.pazarama.moviepicker.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pazarama.moviepicker.common.setMovieImage
import com.pazarama.moviepicker.data.dto.moviedata.Search
import com.pazarama.moviepicker.databinding.ItemMoviesBinding

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private val items = mutableListOf<Search>()

    inner class MoviesViewHolder(private val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Search) {
            binding.tvTitle.text = item.title
            binding.ivPoster.setMovieImage(item.poster)
            binding.root.setOnClickListener{
                onItemClickListener?.invoke(item.imdbID!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val bind = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(bind)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateCharacters(newList: List<Search>) {
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }

    private var onItemClickListener: ((String) -> Unit)? = null

    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }
}