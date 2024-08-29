package com.example.pushtestapplication.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pushtestapplication.ui.theme.PushTestApplicationTheme


@Composable
fun MainView(mainViewModel: MainViewModel = hiltViewModel()) {
    val text by mainViewModel.textFlow.collectAsState()
    mainViewModel.getToken()
    // 텍스트를 UI에 표시
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "my fcm token $text")
        Spacer(modifier = Modifier.height(18.dp))
        Button(
            onClick = { mainViewModel.postPushToken() },
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            ) {
            Text(text = "push token send")
        }
    }
}
