package com.learning.photoshow.core.usecases

import com.learning.photoshow.core.data.State
import com.learning.photoshow.core.data.SinglePhoto
import com.learning.photoshow.core.repos.PhotosRepo
import com.learning.photoshow.core.validators.ShouldBePresent

class PhotoCreationUseCase(private val photosRepo: PhotosRepo) :
    BaseUseCase<SinglePhoto, Boolean>() {

    override suspend fun validate(parameter: SinglePhoto) {
        ShouldBePresent(parameter.name, parameter::name.name)
        ShouldBePresent(parameter.creationTime, parameter::creationTime.name)
        ShouldBePresent(parameter.path, parameter::path.name)
    }

    override suspend fun process(parameter: SinglePhoto): State<Boolean> {
        photosRepo.insert(parameter)
        return State.SuccessState(true)
    }
}