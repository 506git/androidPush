package com.example.pushtestapplication.ui.main

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
    Text(text = "fcm token $text")

}