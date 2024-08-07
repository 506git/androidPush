package com.example.pushtestapplication.service

import com.example.pushtestapplication.repository.DataStoreRepository
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class MyFirebaseInstanceIDService : FirebaseMessagingService() {
    @Inject
    lateinit var defaultPreferences: DataStoreRepository

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        println("push message test $message" )
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        runBlocking {
            println("push test $token")
            defaultPreferences.setToken(token)
        }
    }
}