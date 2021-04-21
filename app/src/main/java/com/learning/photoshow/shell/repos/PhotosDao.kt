package com.learning.photoshow.shell.repos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.learning.photoshow.core.data.PhotoEntity

@Dao
interface PhotosDao {
    @Insert
    fun insert(photo: PhotoEntity)

    @Query("SELECT * FROM photos")
    fun fetchAll(): List<PhotoEntity>
}