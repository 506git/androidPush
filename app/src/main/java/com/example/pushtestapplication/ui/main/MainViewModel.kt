package com.example.pushtestapplication.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pushtestapplication.domain.GetTokenUseCase
import com.example.pushtestapplication.domain.PostPushTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase,
    private val postPushTokenUseCase: PostPushTokenUseCase,
): ViewModel() {
    private val _textFlow = MutableStateFlow("초기 텍스트")
    val textFlow get() = _textFlow.asStateFlow()


    fun getToken() {
        viewModelScope.launch {
            getTokenUseCase.invoke().collect {
                println("fcm token message $it")
                it?.let {
                    _textFlow.emit(it)
                }
            }
        }
    }

    fun postPushToken() {
        viewModelScope.launch {
            postPushTokenUseCase.invoke().collect {
                println("fcm token success $it")

            }
        }
    }
}