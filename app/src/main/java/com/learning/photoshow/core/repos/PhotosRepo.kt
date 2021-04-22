package com.learning.photoshow.core.repos

import com.learning.photoshow.core.data.SinglePhoto

interface PhotosRepo {
    suspend fun insert(photo: SinglePhoto)
    suspend fun fetchAll(): List<SinglePhoto>
}