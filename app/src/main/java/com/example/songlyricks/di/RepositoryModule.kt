package com.example.songlyricks.di

import com.example.songlyricks.data.repository.GeniusRepository
import com.example.songlyricks.data.repository.GeniusRepositoryImpl
import com.example.songlyricks.data.serivce.GeniusService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGeniusRepository(service: GeniusService):GeniusRepository{
        return GeniusRepositoryImpl(service)
    }


}