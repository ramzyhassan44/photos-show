package com.learning.photoshow.core.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class PhotoEntity(
    @PrimaryKey(autoGenerate = true) val photoId: Int,
    @ColumnInfo(name = "creationTime") val creationTime: String,
    @ColumnInfo(name = "photoName") val name: String,
    @ColumnInfo(name = "photoPath") val path: String
)