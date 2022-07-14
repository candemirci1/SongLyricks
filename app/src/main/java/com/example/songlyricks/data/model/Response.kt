package com.example.songlyricks.data.model


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("hits")
    val hits: List<Hit>
)