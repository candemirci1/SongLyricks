package com.example.songlyricks.data.model


import com.google.gson.annotations.SerializedName

data class SearchDTO(
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("response")
    val response: Response
)