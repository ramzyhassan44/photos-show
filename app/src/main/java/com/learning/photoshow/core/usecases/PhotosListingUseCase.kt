package com.learning.photoshow.core.usecases

import com.learning.photoshow.core.data.ResultOutput
import com.learning.photoshow.core.data.SinglePhoto
import com.learning.photoshow.core.repos.PhotosRepo

class PhotosListingUseCase(private val photosRepo: PhotosRepo) :
    BaseUseCase<Nothing?, List<SinglePhoto>>() {
    override suspend fun validate(parameter: Nothing?) = Unit
    override suspend fun process(parameter: Nothing?): ResultOutput<List<SinglePhoto>> =
        ResultOutput.SuccessResult(photosRepo.fetchAll())
}