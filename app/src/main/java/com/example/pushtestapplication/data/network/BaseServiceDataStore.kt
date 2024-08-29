package com.example.pushtestapplication.data.network

import com.example.pushtestapplication.data.model.BaseResponse
import com.example.pushtestapplication.data.model.request.PushTokenRequest

interface BaseServiceDataStore {
    suspend fun postPushToken(pushTokenRequest: PushTokenRequest): BaseResponse<Unit>
}