package com.math.geovoyager.pages.isoscelestriangle

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.math.geovoyager.R
import com.math.geovoyager.databinding.ActivityIsoscelesTriangleBinding

class IsoscelesTriangleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIsoscelesTriangleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIsoscelesTriangleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTopBar()
        initPDF()
    }

    @SuppressLint("SetTextI18n")
    private fun initTopBar() {
        binding.customTopBar.ivBack.setOnClickListener {
            finish()
        }
        binding.customTopBar.tvTopBarTitle.text = "Segitiga Sama Kaki"
    }

    private fun initPDF() {
        binding.pdfView.fromAsset("segitiga-sama-kaki.pdf").load()
    }
}