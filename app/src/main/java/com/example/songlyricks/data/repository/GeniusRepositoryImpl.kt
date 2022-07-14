package com.example.songlyricks.data.repository

import com.example.songlyricks.data.model.SearchDTO
import com.example.songlyricks.data.serivce.GeniusService
import com.example.songlyricks.data.utils.Response
import retrofit2.HttpException
import java.io.IOException

class GeniusRepositoryImpl(private val service: GeniusService): GeniusRepository {
    override suspend fun getSongs(query: String): Response<SearchDTO> {
        return try {
            val search = service.fetchSearch(query)
            Response.Success(search)
        } catch (e: HttpException) {
            Response.Error(e.message.orEmpty(), e.code())
        } catch (e: IOException) {
            Response.Error("check your internet connection")
        }

    }
}