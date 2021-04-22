package com.learning.photoshow.shell.source

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.learning.photoshow.core.data.SinglePhoto

@Entity(tableName = "photos")
data class PhotoEntity(
    @PrimaryKey(autoGenerate = true) val photoId: Int?,
    @ColumnInfo(name = "creationTime") val creationTime: String,
    @ColumnInfo(name = "photoName") val name: String,
    @ColumnInfo(name = "photoPath") val path: String
) {
    companion object Factory {
        fun create(singlePhoto: SinglePhoto): PhotoEntity {
            return PhotoEntity(
                photoId = null,
                creationTime = singlePhoto.creationTime,
                name = singlePhoto.name,
                path = singlePhoto.path
            )
        }
    }
}
