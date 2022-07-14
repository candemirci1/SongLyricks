package com.example.songlyricks.domain

import com.example.songlyricks.data.model.SearchDTO

data class Song(
    val imageUrl: String,
    val name: String,
    val url: String
)

fun SearchDTO.toSongList(): List<Song> {
    return this.response.hits.map {
        Song(
            it.result.headerİmageThumbnailUrl,
            it.result.fullTitle,
            it.result.url
        )
    }
}
