package com.example.songlyricks.data.model


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("annotation_count")
    val annotationCount: Int,
    @SerializedName("api_path")
    val apiPath: String,
    @SerializedName("artist_names")
    val artistNames: String,
    @SerializedName("featured_artists")
    val featuredArtists: List<FeaturedArtist>,
    @SerializedName("full_title")
    val fullTitle: String,
    @SerializedName("header_image_thumbnail_url")
    val headerİmageThumbnailUrl: String,
    @SerializedName("header_image_url")
    val headerİmageUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lyrics_owner_id")
    val lyricsOwnerİd: Int,
    @SerializedName("lyrics_state")
    val lyricsState: String,
    @SerializedName("path")
    val path: String,
    @SerializedName("primary_artist")
    val primaryArtist: PrimaryArtist,
    @SerializedName("pyongs_count")
    val pyongsCount: Int,
    @SerializedName("relationships_index_url")
    val relationshipsİndexUrl: String,
    @SerializedName("release_date_components")
    val releaseDateComponents: ReleaseDateComponents,
    @SerializedName("release_date_for_display")
    val releaseDateForDisplay: String,
    @SerializedName("song_art_image_thumbnail_url")
    val songArtİmageThumbnailUrl: String,
    @SerializedName("song_art_image_url")
    val songArtİmageUrl: String,
    @SerializedName("stats")
    val stats: Stats,
    @SerializedName("title")
    val title: String,
    @SerializedName("title_with_featured")
    val titleWithFeatured: String,
    @SerializedName("url")
    val url: String
)