package com.learning.photoshow.core.usecases

import com.learning.photoshow.core.data.ResultOutput

abstract class BaseUseCase<INPUT, OUTPUT> {
    suspend fun execute(parameter: INPUT): ResultOutput<OUTPUT> = try {
        validate(parameter)
        process(parameter)
    } catch (exception: Exception) {
        ResultOutput.ErrorResult(exception)
    }

    abstract suspend fun validate(parameter: INPUT)

    abstract suspend fun process(parameter: INPUT): ResultOutput<OUTPUT>
}