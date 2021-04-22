package com.learning.photoshow.core.viewmodels

import androidx.lifecycle.ViewModel
import com.learning.photoshow.core.routers.CREATING_PHOTO_ROUTER
import com.learning.photoshow.core.routers.Router
import com.learning.photoshow.core.routers.VIEWING_PHOTO_ROUTER

class MainViewModel(private val router: Router) : ViewModel() {

    fun goToTakePhoto() {
        router.routeTo(CREATING_PHOTO_ROUTER, null, false)
    }

    fun goToViewPhotos() {
        router.routeTo(VIEWING_PHOTO_ROUTER, null, false)
    }

}