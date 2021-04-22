package com.learning.photoshow.shell.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.learning.photoshow.shell.repos.PhotosDao

@Database(entities = [PhotoEntity::class], version = 1)
abstract class PhotoShowDb : RoomDatabase() {

    abstract fun photos(): PhotosDao

    companion object : SingletonHolder<PhotoShowDb, Context>({
        Room.databaseBuilder(
            it.applicationContext,
            PhotoShowDb::class.java, "photos-show.db"
        ).build()
    })
}