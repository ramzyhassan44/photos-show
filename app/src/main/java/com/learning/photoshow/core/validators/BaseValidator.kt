package com.learning.photoshow.core.validators

interface BaseValidator {
    suspend fun orThrow()
}