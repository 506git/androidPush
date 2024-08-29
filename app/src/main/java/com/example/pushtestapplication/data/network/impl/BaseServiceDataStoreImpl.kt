package com.example.pushtestapplication.data.network.impl

import com.example.pushtestapplication.data.model.BaseResponse
import com.example.pushtestapplication.data.model.request.PushTokenRequest
import com.example.pushtestapplication.data.network.BaseService
import com.example.pushtestapplication.data.network.BaseServiceDataStore
import javax.inject.Inject

class BaseServiceDataStoreImpl @Inject constructor(private val baseService: BaseService): BaseServiceDataStore {
    override suspend fun postPushToken(pushTokenRequest: PushTokenRequest): BaseResponse<Unit> {
        return baseService.postPushToken(pushTokenRequest)
    }
}