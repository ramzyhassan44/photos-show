package com.learning.photoshow.core.usecases

import com.learning.photoshow.core.data.ResultOutput
import com.learning.photoshow.core.data.SinglePhoto
import com.learning.photoshow.core.repos.PhotosRepo

class PhotosListingUseCase(private val photosRepo: PhotosRepo) : BaseUseCase<List<SinglePhoto>>() {
    override suspend fun validate() = Unit
    override suspend fun process(): ResultOutput<List<SinglePhoto>> =
        ResultOutput.SuccessResult(
            photosRepo.fetchAll().map { SinglePhoto(it.name, it.creationTime, it.path) })

}