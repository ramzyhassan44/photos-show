package com.learning.photoshow.core.usecases

import com.learning.photoshow.core.data.ResultOutput
import com.learning.photoshow.core.data.SinglePhoto
import com.learning.photoshow.core.repos.PhotosRepo

class PhotoCreationUseCase(private val photosRepo: PhotosRepo) :
    BaseUseCase<SinglePhoto, Nothing?>() {

    override suspend fun validate(parameter: SinglePhoto) {
    }

    override suspend fun process(parameter: SinglePhoto): ResultOutput<Nothing?> {
        photosRepo.insert(parameter)
        return ResultOutput.SuccessResult(null)
    }
}