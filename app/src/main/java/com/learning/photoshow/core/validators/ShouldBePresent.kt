package com.learning.photoshow.core.validators

class ShouldBePresent<T>(private val value: T, private val key: String) : BaseValidator {

    override suspend fun orThrow() {

        val result: Boolean = when (value) {
            is String -> value.isNotBlank()
            is Int -> value != 0
            is Double, Float -> value != 0.0
            is Long -> value != 0L
            else -> value != null
        }
        require(result) { throw Exception("$key is required") }
    }
}