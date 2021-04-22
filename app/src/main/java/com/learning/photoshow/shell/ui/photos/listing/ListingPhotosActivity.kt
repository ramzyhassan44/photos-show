package com.learning.photoshow.shell.ui.photos.listing

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.learning.photoshow.R
import com.learning.photoshow.core.data.SinglePhoto
import com.learning.photoshow.core.data.State
import com.learning.photoshow.core.usecases.PhotosListingUseCase
import com.learning.photoshow.core.viewmodels.PhotoListingViewModel
import com.learning.photoshow.databinding.ActivityListingPhotosBinding
import com.learning.photoshow.shell.repos.PhotoRepoImpl
import com.learning.photoshow.shell.routers.RouterImpl
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
        viewModel = byViewModels {
            PhotoListingViewModel(
                PhotosListingUseCase(photosRepo),
                RouterImpl(this)
            )
        }
        supportActionBar?.title = getString(R.string.view_photos)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        observeLiveData()
        viewModel.getPhotosList()
    }

    private fun observeLiveData() {
        with(viewModel) {
            photosState.observe(this@ListingPhotosActivity, ::handleState)
        }
    }

    private fun handleState(state: State<List<SinglePhoto>>) {
        when (state) {
            is State.ErrorState -> showError(state.exception.message)
            is State.SuccessState -> updateUi(state.data)
        }
    }

    private fun showError(message: String?) {
        binding.contentLoading.hide()
        Toast.makeText(this, message, Toast.LENGTH_LONG)
            .show()
    }

    private fun updateUi(photos: List<SinglePhoto>) {
        binding.contentLoading.visibility = View.GONE
        if (photos.isEmpty()) {
            binding.layoutNoData.visibility = View.VISIBLE
            binding.photosRecycler.visibility = View.GONE

        } else {
            binding.layoutNoData.visibility = View.GONE
            binding.photosRecycler.visibility = View.VISIBLE
            binding.photosRecycler.layoutManager = GridLayoutManager(this, 2)
            adapter = ListingPhotosAdapter(photos, viewModel.onItemClicked)
            binding.photosRecycler.adapter = adapter
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}