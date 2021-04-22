package com.learning.photoshow.shell.repos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.learning.photoshow.shell.source.PhotoEntity

@Dao
interface PhotosDao {
    @Insert
    suspend fun insert(photo: PhotoEntity?)

    @Query("SELECT * FROM photos")
    suspend fun fetchAll(): List<PhotoEntity>
}