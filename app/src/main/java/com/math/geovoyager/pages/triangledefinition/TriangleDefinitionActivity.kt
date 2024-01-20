package com.math.geovoyager.pages.triangledefinition

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.math.geovoyager.databinding.ActivityTriangleDefinitionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TriangleDefinitionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTriangleDefinitionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTriangleDefinitionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTopBar()
        initPDF()
    }

    @SuppressLint("SetTextI18n")
    private fun initTopBar() {
        binding.customTopBar.ivBack.setOnClickListener {
            finish()
        }
        binding.customTopBar.tvTopBarTitle.text = "Pengertian Segitiga"
    }

    private fun initPDF() {
        binding.pdfView.fromAsset("pengertian-segitiga.pdf").load()
    }
}