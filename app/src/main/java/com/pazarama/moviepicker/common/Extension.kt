package com.pazarama.moviepicker.common

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.pazarama.moviepicker.R

fun ImageView.setMovieImage(moviePath:String?) {
    Glide.with(this).load(moviePath)
        .placeholder(R.drawable.ic_downloading)
        .error(R.drawable.ic_error)
        .into(this)
}