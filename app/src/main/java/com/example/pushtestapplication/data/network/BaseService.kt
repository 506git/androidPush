package com.example.pushtestapplication.data.network

import com.example.pushtestapplication.data.model.BaseResponse
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BaseService {
    @GET("")
    suspend fun postPushToken(
        @Path("token") token : String,
    ): BaseResponse<Unit>

}