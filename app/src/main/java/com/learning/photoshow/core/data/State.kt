package com.learning.photoshow.core.data

sealed class State<out T> {
    data class SuccessState<out T>(val data: T) : State<T>()
    data class ErrorState<T>(val data: T?, val exception: Exception) : State<T>()
}