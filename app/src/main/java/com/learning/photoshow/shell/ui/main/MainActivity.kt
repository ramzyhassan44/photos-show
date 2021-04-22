package com.learning.photoshow.shell.ui.main

import android.Manifest
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.FileProvider
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_COLLAPSED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import com.learning.photoshow.BuildConfig
import com.learning.photoshow.core.usecases.PhotoCreationUseCase
import com.learning.photoshow.core.viewmodels.MainViewModel
import com.learning.photoshow.databinding.ActivityMainBinding
import com.learning.photoshow.shell.repos.PhotoRepoImpl
import com.learning.photoshow.shell.routers.RouterImpl
import com.learning.photoshow.shell.source.PhotoShowDb
import com.learning.photoshow.shell.utils.byViewModels
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var currentPhotoPath: String
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val photoRepo = PhotoRepoImpl(PhotoShowDb.getInstance(this).photosDao())
        viewModel =
            byViewModels { MainViewModel(RouterImpl(this), PhotoCreationUseCase(photoRepo)) }
        binding.viewPhotos.setOnClickListener {
            viewModel.goToViewPhotos()
        }
        binding.takePhoto.setOnClickListener {
            requestPermissionContract.launch(Manifest.permission.CAMERA)
        }
        initializeBottomSheet()
        binding.bottomSheetLayout.save.setOnClickListener {
            bottomSheetBehavior.state = STATE_COLLAPSED
            viewModel.savePhoto(
                binding.bottomSheetLayout.photoName.text.toString(),
                currentPhotoPath,
                SimpleDateFormat("HH:mm aa", Locale.ENGLISH).format(Date())
            )
        }
        binding.bottomSheetLayout.cancel.setOnClickListener {
            bottomSheetBehavior.state = STATE_COLLAPSED
        }

    }


    private val cameraResultContract =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { capturedSuccessfully ->
            if (capturedSuccessfully) {
                openPhotoCreationSheet()
            } else {
                currentPhotoPath = ""
            }

        }

    private fun openPhotoCreationSheet() {
        binding.bottomSheetLayout.imagePreview.setImageURI(Uri.fromFile(File(currentPhotoPath)))
        bottomSheetBehavior.state = STATE_EXPANDED

    }

    private fun initializeBottomSheet() {
        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheetLayout.bottomSheet)
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) = Unit
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == STATE_COLLAPSED) {
                    currentPhotoPath = ""
                }
            }
        })
    }

    private val requestPermissionContract =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) openCamera()
        }

    private fun openCamera() {
        val uri = FileProvider.getUriForFile(
            this,
            BuildConfig.APPLICATION_ID + ".provider",
            createImageFile()
        )
        cameraResultContract.launch(uri)
    }

    private fun createImageFile(): File {
        val timeStamp: String =
            SimpleDateFormat("yyyy-MM-dd_HH:mm:ss", Locale.ENGLISH).format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_",
            ".jpg",
            storageDir
        ).apply {
            currentPhotoPath = absolutePath
        }
    }
}