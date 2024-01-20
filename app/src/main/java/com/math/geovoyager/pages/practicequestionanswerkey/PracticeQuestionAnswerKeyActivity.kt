package com.math.geovoyager.pages.practicequestionanswerkey

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.math.geovoyager.databinding.ActivityPracticeQuestionAnswerKeyBinding
import com.math.geovoyager.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PracticeQuestionAnswerKeyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPracticeQuestionAnswerKeyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPracticeQuestionAnswerKeyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTopBar()
        initPDF()
    }

    @SuppressLint("SetTextI18n")
    private fun initTopBar() {
        binding.customTopBar.ivBack.setOnClickListener {
            finish()
        }

        val type = intent.getStringExtra(Constants.PREPARE_PRACTICE_QUESTION_TYPE)
        binding.customTopBar.tvTopBarTitle.text = "Kunci Jawaban Soal Latihan $type"
    }

    private fun initPDF() {
        val type = intent.getStringExtra(Constants.PREPARE_PRACTICE_QUESTION_TYPE)
        if (type == "LOTS") {
            binding.pdfView.fromAsset("jawaban-soal-latihan-lots.pdf").load()
        }

        if (type == "MOTS") {
            binding.pdfView.fromAsset("jawaban-soal-latihan-mots.pdf").load()
        }

        if (type == "HOTS") {
            binding.pdfView.fromAsset("jawaban-soal-latihan-hots.pdf").load()
        }
    }
}