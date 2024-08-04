package com.example.pushtestapplication.di

import com.example.pushtestapplication.repository.DataStoreRepository
import com.example.pushtestapplication.repository.impl.DataStoreRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {
    @Binds
    fun bindsDataStoreRepository(impl: DataStoreRepositoryImpl): DataStoreRepository
}