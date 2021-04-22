package com.learning.photoshow.shell.routers

import com.learning.photoshow.core.routers.CREATING_PHOTO_ROUTER
import com.learning.photoshow.core.routers.LISTING_PHOTOS_ROUTER
import com.learning.photoshow.core.routers.VIEWING_PHOTO_ROUTER
import com.learning.photoshow.shell.ui.photos.creation.CreatingPhotoActivity
import com.learning.photoshow.shell.ui.photos.listing.ListingPhotosActivity
import com.learning.photoshow.shell.ui.photos.preview.ViewingPhotoActivity

object RoutingTable {
    private var applicationRouters: HashMap<String, Class<*>>? = null
    val routers: HashMap<String, Class<*>>?
        get() {
            if (applicationRouters == null) {
                setAppRouters()
            }
            return applicationRouters
        }

    private fun setAppRouters() {
        applicationRouters = HashMap<String, Class<*>>().apply {
            put(CREATING_PHOTO_ROUTER, CreatingPhotoActivity::class.java)
            put(LISTING_PHOTOS_ROUTER, ListingPhotosActivity::class.java)
            put(VIEWING_PHOTO_ROUTER, ViewingPhotoActivity::class.java)
        }
    }


}