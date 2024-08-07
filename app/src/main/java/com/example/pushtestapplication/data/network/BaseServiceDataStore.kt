package com.example.pushtestapplication.data.network

import com.example.pushtestapplication.data.model.BaseResponse

interface BaseServiceDataStore {
    suspend fun postPushToken(token: String): BaseResponse<Unit>
}