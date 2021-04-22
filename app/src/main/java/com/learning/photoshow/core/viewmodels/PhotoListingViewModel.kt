package com.learning.photoshow.core.viewmodels

import androidx.lifecycle.ViewModel
import com.learning.photoshow.core.usecases.PhotoCreationUseCase

class PhotoListingViewModel(val photoCreationUseCase: PhotoCreationUseCase) : ViewModel() {

}