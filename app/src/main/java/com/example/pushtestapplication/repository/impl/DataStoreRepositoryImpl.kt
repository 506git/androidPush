package com.example.pushtestapplication.repository.impl

import com.example.pushtestapplication.data.datastore.DefaultDataStore
import com.example.pushtestapplication.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataStoreRepositoryImpl @Inject constructor(
    private val dataStore: DefaultDataStore
): DataStoreRepository {
    override suspend fun getToken(): Flow<String?> {
        return dataStore.getFCMToken()
    }

    override suspend fun setToken(token: String) {
        println("push Token $token")
        dataStore.setFCMToken(token)
    }
}