package com.learning.photoshow.core.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.photoshow.core.data.SinglePhoto
import com.learning.photoshow.core.data.State
import com.learning.photoshow.core.routers.Router
import com.learning.photoshow.core.routers.VIEWING_PHOTO_ROUTER
import com.learning.photoshow.core.usecases.PhotosListingUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhotoListingViewModel(
    private val photosListingUseCase: PhotosListingUseCase,
    val router: Router
) : ViewModel() {
    var photosState = MutableLiveData<State<List<SinglePhoto>>>()
    private var photos = listOf<SinglePhoto>()
    fun getPhotosList() {
        viewModelScope.launch {
            delay(2000)
            val state = withContext(Dispatchers.IO) { photosListingUseCase.execute(null) }
            photosState.postValue(state)
            photos = (state as State.SuccessState).data
        }
    }

    val onItemClicked: (position: Int) -> Unit = {
        with(photos[it]) {
            router.routeTo(VIEWING_PHOTO_ROUTER, this.path, false)
        }
    }
}