package com.learning.photoshow.core.repos

import com.learning.photoshow.core.data.PhotoEntity

interface PhotosRepo {
    fun insert(photo: PhotoEntity?)
    fun fetchAll(): List<PhotoEntity>
}