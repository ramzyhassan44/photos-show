package com.learning.photoshow.shell.repos

import com.learning.photoshow.core.data.SinglePhoto
import com.learning.photoshow.core.repos.PhotosRepo
import com.learning.photoshow.shell.source.PhotoEntity

class PhotoRepoImpl(private val dao: PhotosDao) : PhotosRepo {
    override suspend fun insert(photo: SinglePhoto) {
        dao.insert(PhotoEntity.create(photo))
    }

    override suspend fun fetchAll(): List<SinglePhoto> =
        dao.fetchAll().map { SinglePhoto(it.name, it.creationTime, it.path) }

}