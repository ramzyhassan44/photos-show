package com.learning.photoshow.shell.repos

import com.learning.photoshow.core.data.PhotoEntity
import com.learning.photoshow.core.repos.PhotosRepo

class PhotoRepoImpl(private val dao: PhotosDao) : PhotosRepo {
    override fun insert(photo: PhotoEntity?) {
        dao.insert(photo)
    }

    override fun fetchAll(): List<PhotoEntity> = dao.fetchAll()

}