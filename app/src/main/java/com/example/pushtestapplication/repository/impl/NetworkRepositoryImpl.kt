package com.example.pushtestapplication.repository.impl

import com.example.pushtestapplication.data.network.BaseService
import com.example.pushtestapplication.data.network.BaseServiceDataStore
import com.example.pushtestapplication.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val baseServiceDataStore: BaseServiceDataStore
): NetworkRepository {
    override suspend fun postPushToken(token: String): Flow<Unit> {
        return flow{
            baseServiceDataStore.postPushToken(token)
        }
    }
}