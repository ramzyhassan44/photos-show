package com.learning.photoshow.core.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.photoshow.core.routers.LISTING_PHOTOS_ROUTER
import com.learning.photoshow.core.routers.Router
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(private val router: Router) : ViewModel() {
    fun initialize() {
        viewModelScope.launch {
            delay(3000)
            router.routeTo(LISTING_PHOTOS_ROUTER, null, true)
        }
    }

}