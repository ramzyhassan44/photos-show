package com.learning.photoshow.shell.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learning.photoshow.core.viewmodels.SplashViewModel
import com.learning.photoshow.databinding.ActivitySplashBinding
import com.learning.photoshow.shell.routers.RouterImpl
import com.learning.photoshow.shell.utils.byViewModels

class SplashActivity : AppCompatActivity() {
    private val viewModel by lazy {
        byViewModels { SplashViewModel(RouterImpl(this)) }
    }
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.initialize()
    }
}