package com.example.pushtestapplication.data.network

import com.example.pushtestapplication.data.model.BaseResponse
import com.example.pushtestapplication.data.model.request.PushTokenRequest
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BaseService {
    @POST("$VERSION/$PATH_NOTIFICATION")
    suspend fun postPushToken(
        @Body tokenIssueData: PushTokenRequest,
    ): BaseResponse<Unit>

    companion object {
        const val VERSION: String = "v1"

        const val PATH_NOTIFICATION = "notification"
    }
}