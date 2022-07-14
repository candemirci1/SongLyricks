package com.example.songlyricks.data.model


import com.google.gson.annotations.SerializedName

data class ReleaseDateComponents(
    @SerializedName("day")
    val day: Int,
    @SerializedName("month")
    val month: Int,
    @SerializedName("year")
    val year: Int
)