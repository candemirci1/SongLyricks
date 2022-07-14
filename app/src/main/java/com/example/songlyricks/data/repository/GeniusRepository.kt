package com.example.songlyricks.data.repository

import com.example.songlyricks.data.model.SearchDTO
import com.example.songlyricks.data.utils.Response

interface GeniusRepository {

    suspend fun getSongs(q: String): Response<SearchDTO>
}