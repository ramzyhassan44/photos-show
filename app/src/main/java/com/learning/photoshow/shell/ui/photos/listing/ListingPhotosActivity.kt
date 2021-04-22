package com.learning.photoshow.shell.ui.photos.listing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.learning.photoshow.R
import com.learning.photoshow.core.data.SinglePhoto
import com.learning.photoshow.core.usecases.PhotoCreationUseCase
import com.learning.photoshow.core.viewmodels.PhotoListingViewModel
import com.learning.photoshow.databinding.ActivityListingPhotosBinding
import com.learning.photoshow.shell.repos.PhotoRepoImpl
import com.learning.photoshow.shell.source.PhotoShowDb
import com.learning.photoshow.shell.utils.byViewModels

class ListingPhotosActivity : AppCompatActivity() {

    lateinit var binding: ActivityListingPhotosBinding
    lateinit var viewModel: PhotoListingViewModel
    var adapter: ListingPhotosAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListingPhotosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val photosRepo = PhotoRepoImpl(PhotoShowDb.getInstance(applicationContext).photosDao())
        viewModel = byViewModels { PhotoListingViewModel(PhotoCreationUseCase(photosRepo)) }

        supportActionBar?.title = getString(R.string.view_photos)
        binding.photosRecycler.layoutManager = GridLayoutManager(this, 2)
        adapter = ListingPhotosAdapter(
            listOf(
                SinglePhoto("Name", creationTime = "TEST", ""),
                SinglePhoto("Name", creationTime = "TEST", ""),
                SinglePhoto("Name", creationTime = "TEST", ""),
                SinglePhoto("Name", creationTime = "TEST", ""),
                SinglePhoto("Name", creationTime = "TEST", ""),
                SinglePhoto("Name", creationTime = "TEST", ""),
                SinglePhoto("Name", creationTime = "TEST", ""),
                SinglePhoto("Name", creationTime = "TEST", ""),
                SinglePhoto("Name", creationTime = "TEST", ""),
                SinglePhoto("Name", creationTime = "TEST", "")
            )
        )
        binding.photosRecycler.adapter = adapter

    }
}