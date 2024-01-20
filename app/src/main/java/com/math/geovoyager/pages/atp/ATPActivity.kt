package com.math.geovoyager.pages.atp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.math.geovoyager.databinding.ActivityAtpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ATPActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTopBar()
    }

    @SuppressLint("SetTextI18n")
    private fun initTopBar() {
        binding.customTopBar.ivBack.setOnClickListener {
            finish()
        }
        binding.customTopBar.tvTopBarTitle.text = "Alur Tujuan Pembelajaran"
    }
}