package com.learning.photoshow.shell.repos

import com.learning.photoshow.core.data.PhotoEntity
import com.learning.photoshow.core.data.SinglePhoto
import com.learning.photoshow.core.repos.PhotosRepo

class PhotoRepoImpl(private val dao: PhotosDao) : PhotosRepo {
    override fun insert(photo: SinglePhoto) {
        dao.insert(PhotoEntity.create(photo))
    }

    override fun fetchAll(): List<SinglePhoto> =
        dao.fetchAll().map { SinglePhoto(it.name, it.creationTime, it.path) }

}