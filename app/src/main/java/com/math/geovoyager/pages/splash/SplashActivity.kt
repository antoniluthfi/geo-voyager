package com.math.geovoyager.pages.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.math.geovoyager.R
import com.math.geovoyager.databinding.ActivitySplashBinding
import com.math.geovoyager.pages.home.HomeActivity
import com.math.geovoyager.utils.StatusBar.changeStatusBarColor
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        changeStatusBarColor(this, R.color.white, true)
        setContentView(binding.root)

        initAnimation()
        initButtonGeoVoyager()
    }

    private fun initAnimation() {
        val logoAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.logoImage.startAnimation(logoAnimation)

        val slideUpAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        binding.geoVoyagerButton.startAnimation(slideUpAnimation)
    }

    private fun initButtonGeoVoyager() {
        binding.geoVoyagerButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}