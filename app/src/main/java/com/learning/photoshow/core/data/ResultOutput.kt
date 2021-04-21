package com.learning.photoshow.core.data

sealed class ResultOutput<out R> {
    data class SuccessResult<out T>(val data: T) : ResultOutput<T>()
    data class ErrorResult(val exception: Exception) : ResultOutput<Nothing>()
}