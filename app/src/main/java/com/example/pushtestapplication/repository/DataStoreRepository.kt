package com.example.pushtestapplication.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun getToken(): Flow<String?>
    suspend fun setToken(token: String)
}