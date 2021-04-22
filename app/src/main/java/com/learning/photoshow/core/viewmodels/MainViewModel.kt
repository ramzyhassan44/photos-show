package com.learning.photoshow.core.viewmodels

import androidx.lifecycle.ViewModel
import com.learning.photoshow.core.routers.LISTING_PHOTOS_ROUTER
import com.learning.photoshow.core.routers.Router

class MainViewModel(private val router: Router) : ViewModel() {

    fun goToViewPhotos() {
        router.routeTo(LISTING_PHOTOS_ROUTER, null, false)
    }

}