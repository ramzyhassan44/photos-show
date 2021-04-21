package com.learning.photoshow.core.usecases

import com.learning.photoshow.core.data.ResultOutput

abstract class BaseUseCase<T : Any> {
    suspend fun execute(): ResultOutput<T> = try {
        validate()
        process()
    } catch (exception: Exception) {
        ResultOutput.ErrorResult(exception)
    }

    abstract suspend fun validate()

    abstract suspend fun process(): ResultOutput<T>
}