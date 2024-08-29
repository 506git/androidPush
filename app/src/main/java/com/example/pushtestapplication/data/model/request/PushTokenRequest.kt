package com.example.pushtestapplication.data.model.request

data class PushTokenRequest(
    val deviceId: String,
    val token: String,
)
