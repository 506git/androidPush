package com.example.pushtestapplication.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun MainView(mainViewModel: MainViewModel = hiltViewModel()) {
    val text by mainViewModel.textFlow.collectAsState()
    mainViewModel.getToken()
    // 텍스트를 UI에 표시
    Column {
        Text(text = "fcm token $text")
        Button(onClick = { mainViewModel.postPushToken() }) {

        }
    }

}