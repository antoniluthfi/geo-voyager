package com.math.geovoyager.pages.cp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.math.geovoyager.R
import com.math.geovoyager.databinding.ActivityCpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CPActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTopBar()
    }

    @SuppressLint("SetTextI18n")
    private fun initTopBar() {
        binding.customTopBar.ivBack.setOnClickListener {
            finish()
        }
        binding.customTopBar.tvTopBarTitle.text = "Capaian Pembelajaran"
    }
}