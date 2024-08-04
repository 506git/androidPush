package com.example.pushtestapplication.ui.service

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseInstanceIDService : FirebaseMessagingService() {
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        println("push message test $message" )
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        println("push test $token")

    }
}