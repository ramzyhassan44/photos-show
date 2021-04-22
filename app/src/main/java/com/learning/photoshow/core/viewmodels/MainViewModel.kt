package com.learning.photoshow.core.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.photoshow.core.data.SinglePhoto
import com.learning.photoshow.core.data.State
import com.learning.photoshow.core.routers.LISTING_PHOTOS_ROUTER
import com.learning.photoshow.core.routers.Router
import com.learning.photoshow.core.usecases.PhotoCreationUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val router: Router,
    private val photoCreationUseCase: PhotoCreationUseCase
) : ViewModel() {

    val state = MutableLiveData<State<Boolean>>()

    fun goToViewPhotos() {
        router.routeTo(LISTING_PHOTOS_ROUTER, null, false)
    }

    fun savePhoto(name: String, path: String, creationTime: String) {
        viewModelScope.launch {
            val result = photoCreationUseCase.execute(SinglePhoto(name, creationTime, path))
            state.postValue(result)
        }
    }

}