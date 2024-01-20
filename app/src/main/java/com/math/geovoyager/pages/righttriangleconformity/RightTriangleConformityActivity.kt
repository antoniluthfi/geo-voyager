package com.math.geovoyager.pages.righttriangleconformity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.math.geovoyager.R
import com.math.geovoyager.databinding.ActivityRightTriangleConformityBinding

class RightTriangleConformityActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRightTriangleConformityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRightTriangleConformityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTopBar()
        initPDF()
    }

    @SuppressLint("SetTextI18n")
    private fun initTopBar() {
        binding.customTopBar.ivBack.setOnClickListener {
            finish()
        }
        binding.customTopBar.tvTopBarTitle.text = "Kekongruenan Segitiga Siku-Siku"
    }

    private fun initPDF() {
        binding.pdfView.fromAsset("kekongruenan-segitiga.pdf").load()
    }
}