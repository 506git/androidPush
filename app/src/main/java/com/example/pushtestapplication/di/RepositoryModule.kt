package com.example.pushtestapplication.di

import com.example.pushtestapplication.data.network.BaseServiceDataStore
import com.example.pushtestapplication.data.network.impl.BaseServiceDataStoreImpl
import com.example.pushtestapplication.repository.DataStoreRepository
import com.example.pushtestapplication.repository.NetworkRepository
import com.example.pushtestapplication.repository.impl.DataStoreRepositoryImpl
import com.example.pushtestapplication.repository.impl.NetworkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {
    @Binds
    fun bindsDataStoreRepository(impl: DataStoreRepositoryImpl): DataStoreRepository

    @Binds
    fun bindsNetworkRepository(impl: NetworkRepositoryImpl): NetworkRepository

    @Binds
    fun bindsBaseDataStoreRepository(impl: BaseServiceDataStoreImpl): BaseServiceDataStore

}