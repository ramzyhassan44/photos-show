package com.learning.photoshow.shell.ui.photos.preview

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learning.photoshow.R
import com.learning.photoshow.databinding.ActivityPreviewBinding
import com.learning.photoshow.shell.routers.BUNDLE_KEY
import java.io.File

class ViewingPhotoActivity : AppCompatActivity() {
    lateinit var binding: ActivityPreviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.image_preview)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val imagePath = intent.getStringExtra(BUNDLE_KEY)
        binding.imageViewer.setImageURI(Uri.fromFile(File(imagePath)))
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}