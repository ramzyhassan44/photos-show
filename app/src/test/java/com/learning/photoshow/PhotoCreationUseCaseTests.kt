package com.learning.photoshow

import com.learning.photoshow.shell.source.PhotoEntity
import com.learning.photoshow.core.data.State
import com.learning.photoshow.core.data.SinglePhoto
import com.learning.photoshow.core.usecases.PhotoCreationUseCase
import com.learning.photoshow.shell.repos.PhotoRepoImpl
import com.learning.photoshow.shell.repos.PhotosDao
import io.mockk.coJustRun
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PhotoCreationUseCaseTests {
    private val photosDao = mockk<PhotosDao>()
    private val photosRepo = PhotoRepoImpl(photosDao)

    @Test
    fun `creating photo with empty name throws exception`(): Unit = runBlocking {
        val singlePhoto = SinglePhoto(name = "", creationTime = "10:00 PM", path = "//photoPath")
        try {
            PhotoCreationUseCase(photosRepo).execute(singlePhoto)
        } catch (e: Exception) {
            assertEquals("${singlePhoto::name.name} is required", e.message)
        }
    }

    @Test
    fun `creating photo with empty creationTime throws exception`(): Unit = runBlocking {
        val singlePhoto = SinglePhoto(name = "Photo name", creationTime = "", path = "//photoPath")
        try {
            PhotoCreationUseCase(photosRepo).execute(singlePhoto)
        } catch (e: Exception) {
            assertEquals("${singlePhoto::creationTime.name} is required", e.message)
        }
    }

    @Test
    fun `creating photo with empty path throws exception`(): Unit = runBlocking {
        val singlePhoto = SinglePhoto(name = "Photo name", creationTime = "10:00 PM", path = "")
        try {
            PhotoCreationUseCase(photosRepo).execute(singlePhoto)
        } catch (e: Exception) {
            assertEquals("${singlePhoto::path.name} is required", e.message)
        }
    }

    @Test
    fun `creating photo with valid data works`(): Unit = runBlocking {
        val singlePhoto =
            SinglePhoto(name = "Photo name", creationTime = "10:00 PM", path = "//photoPath")
        coJustRun { photosDao.insert(PhotoEntity.create(singlePhoto)) }
        val result =
            PhotoCreationUseCase(photosRepo).execute(singlePhoto) as State.SuccessState
        assertTrue(result.data)
    }
}