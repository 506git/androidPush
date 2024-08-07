package com.example.pushtestapplication.domain

import com.example.pushtestapplication.repository.DataStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
){
    suspend operator fun invoke(): Flow<String?> {
        return  flow {
            val token = dataStoreRepository.getToken().firstOrNull()
            println("fmc token Get $token")
            emit(token)
        }.flowOn(Dispatchers.IO)
    }
}