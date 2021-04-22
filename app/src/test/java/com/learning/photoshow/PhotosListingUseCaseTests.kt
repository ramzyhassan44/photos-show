package com.learning.photoshow

import com.learning.photoshow.shell.source.PhotoEntity
import com.learning.photoshow.core.data.State
import com.learning.photoshow.core.data.SinglePhoto
import com.learning.photoshow.core.usecases.PhotosListingUseCase
import com.learning.photoshow.shell.repos.PhotoRepoImpl
import com.learning.photoshow.shell.repos.PhotosDao
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class PhotosListingUseCaseTests {
    private val photosDao = mockk<PhotosDao>()
    private val photosRepo = PhotoRepoImpl(photosDao)

    @Test
    fun `listing photos works correctly and map data correctly`(): Unit = runBlocking {
        val singlePhoto1 =
            SinglePhoto(name = "name 1", creationTime = "10:00 PM", path = "//photoPath1")
        val singlePhoto2 =
            SinglePhoto(name = "name 2", creationTime = "10:00 PM", path = "//photoPath1")
        val singlePhoto3 =
            SinglePhoto(name = "name 3", creationTime = "10:00 PM", path = "//photoPath1")
        coEvery { photosDao.fetchAll() } answers {
            listOf(
                PhotoEntity.create(singlePhoto1),
                PhotoEntity.create(singlePhoto2),
                PhotoEntity.create(singlePhoto3)
            )
        }
        val result = PhotosListingUseCase(photosRepo).execute(null) as State.SuccessState
        assertEquals(3, result.data.size)
    }
}