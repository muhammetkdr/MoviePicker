package com.pazarama.moviepicker.data.dto.search


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("Source")
    val source: String?,
    @SerializedName("Value")
    val value: String?
)