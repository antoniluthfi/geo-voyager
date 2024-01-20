package com.math.geovoyager.pages.materials

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.math.geovoyager.R
import com.math.geovoyager.databinding.ActivityMaterialsBinding
import com.math.geovoyager.pages.isoscelestriangle.IsoscelesTriangleActivity
import com.math.geovoyager.pages.righttriangleconformity.RightTriangleConformityActivity
import com.math.geovoyager.pages.triangledefinition.TriangleDefinitionActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MaterialsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMaterialsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTopBar()
        initTriangleDefinitionButton()
        initIsoscelesTrianglesButton()
        initRightTriangleConformityButton()
    }

    @SuppressLint("SetTextI18n")
    private fun initTopBar() {
        binding.customTopBar.ivBack.setOnClickListener {
            finish()
        }
        binding.customTopBar.tvTopBarTitle.text = "Materi"
    }

    private fun initTriangleDefinitionButton() {
        binding.triangleDefinitionButton.setOnClickListener {
            val intent = Intent(this, TriangleDefinitionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initIsoscelesTrianglesButton() {
        binding.isoscelesTrianglesButton.setOnClickListener {
            val intent = Intent(this, IsoscelesTriangleActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initRightTriangleConformityButton() {
        binding.rightTriangleConformityButton.setOnClickListener {
            val intent = Intent(this, RightTriangleConformityActivity::class.java)
            startActivity(intent)
        }
    }
}