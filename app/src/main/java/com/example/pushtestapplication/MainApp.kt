package com.example.pushtestapplication

import android.app.Application
import android.content.Context
import com.example.pushtestapplication.repository.DataStoreRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import java.util.UUID
import javax.inject.Inject

@HiltAndroidApp
class MainApp: Application()  {
    @Inject lateinit var dataStore: DataStoreRepository

    override fun onCreate() {
        super.onCreate()
        setGUID()
    }

    private fun setGUID() {
        val deviceId = runBlocking { dataStore.getDeviceId().firstOrNull() }
        println("uniqueID $deviceId")

        if (deviceId.isNullOrBlank()) {
            val uniqueID = UUID.randomUUID().toString()
            println("uniqueID2 $uniqueID")
            runBlocking {
                dataStore.setDeviceId(uniqueID)
            }
        }
    }
}