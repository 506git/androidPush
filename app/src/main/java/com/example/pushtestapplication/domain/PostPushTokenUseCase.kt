package com.example.pushtestapplication.domain

import com.example.pushtestapplication.repository.DataStoreRepository
import com.example.pushtestapplication.repository.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostPushTokenUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
    private val networkRepository: NetworkRepository
){
    suspend operator fun invoke(): Flow<Unit?> {
        return flow {
            val token = dataStoreRepository.getToken().firstOrNull()
            token?.let {
                emit(networkRepository.postPushToken(token = token).firstOrNull())
            } ?: println("token not found")
        }.flowOn(Dispatchers.IO)
    }
}