package com.learning.photoshow.shell.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.learning.photoshow.shell.repos.PhotosDao

@Database(entities = [PhotoEntity::class], version = 1)
abstract class PhotoShowDb : RoomDatabase() {

    abstract fun photosDao(): PhotosDao

    companion object {

        @Volatile
        private var instance: PhotoShowDb? = null

        fun getInstance(context: Context): PhotoShowDb = instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context): PhotoShowDb =
            Room.databaseBuilder(
                context.applicationContext,
                PhotoShowDb::class.java,
                "photos-show.db"
            ).fallbackToDestructiveMigration()
                .build()
    }
}