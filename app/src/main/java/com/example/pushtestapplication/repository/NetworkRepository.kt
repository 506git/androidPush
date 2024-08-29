package com.example.pushtestapplication.repository

import kotlinx.coroutines.flow.Flow


interface NetworkRepository {
    suspend fun postPushToken(token: String, deviceId: String?): Flow<Unit>
}