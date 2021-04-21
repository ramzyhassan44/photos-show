package com.learning.photoshow.core.repos

import com.learning.photoshow.core.data.SinglePhoto

interface PhotosRepo {
    fun insert(photo: SinglePhoto)
    fun fetchAll(): List<SinglePhoto>
}