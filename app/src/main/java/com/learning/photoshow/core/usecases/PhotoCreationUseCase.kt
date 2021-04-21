package com.learning.photoshow.core.usecases

import com.learning.photoshow.core.data.PhotoEntity
import com.learning.photoshow.core.data.ResultOutput
import com.learning.photoshow.core.repos.PhotosRepo

class PhotoCreationUseCase(private val photosRepo: PhotosRepo) : BaseUseCase<Boolean>() {

    private val photo: PhotoEntity? = null
    override suspend fun validate() {
        TODO("Not yet implemented")
    }

    override suspend fun process(): ResultOutput<Boolean> {
        photosRepo.insert(photo)
        return ResultOutput.SuccessResult(true)
    }
}