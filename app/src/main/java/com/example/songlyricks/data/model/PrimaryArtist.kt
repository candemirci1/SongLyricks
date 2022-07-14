package com.example.songlyricks.data.model


import com.google.gson.annotations.SerializedName

data class PrimaryArtist(
    @SerializedName("api_path")
    val apiPath: String,
    @SerializedName("header_image_url")
    val headerİmageUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("iq")
    val iq: Int,
    @SerializedName("is_meme_verified")
    val isMemeVerified: Boolean,
    @SerializedName("is_verified")
    val isVerified: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)