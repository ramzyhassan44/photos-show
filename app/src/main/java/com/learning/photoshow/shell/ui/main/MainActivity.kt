package com.learning.photoshow.shell.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learning.photoshow.core.viewmodels.MainViewModel
import com.learning.photoshow.databinding.ActivityMainBinding
import com.learning.photoshow.shell.routers.RouterImpl
import com.learning.photoshow.shell.utils.byViewModels

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        byViewModels { MainViewModel(RouterImpl(this)) }
    }
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPhotos.setOnClickListener {
            viewModel.goToViewPhotos()
        }
    }
}