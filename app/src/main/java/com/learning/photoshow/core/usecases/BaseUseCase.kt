package com.learning.photoshow.core.usecases

import com.learning.photoshow.core.data.State

abstract class BaseUseCase<INPUT, OUTPUT> {
    suspend fun execute(parameter: INPUT): State<OUTPUT> = try {
        validate(parameter)
        process(parameter)
    } catch (exception: Exception) {
        State.ErrorState(null, exception)
    }

    abstract suspend fun validate(parameter: INPUT)

    abstract suspend fun process(parameter: INPUT): State<OUTPUT>
}