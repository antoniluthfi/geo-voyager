package com.math.geovoyager.pages.preparepracticequestion

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import com.math.geovoyager.databinding.ActivityPreparePracticeQuestionBinding
import com.math.geovoyager.pages.practicequestionquiz.PracticeQuestionQuizActivity
import com.math.geovoyager.utils.Constants.PREPARE_PRACTICE_QUESTION_TYPE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PreparePracticeQuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPreparePracticeQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreparePracticeQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTopBar()
        initDescriptionTitle()
        initButton()
    }

    @SuppressLint("SetTextI18n")
    private fun initTopBar() {
        binding.customTopBar.ivBack.setOnClickListener {
            finish()
        }

        val type = intent.getStringExtra(PREPARE_PRACTICE_QUESTION_TYPE)
        binding.customTopBar.tvTopBarTitle.text = "Persiapan Latihan Soal $type"
    }

    private fun initDescriptionTitle() {
        val type = intent.getStringExtra(PREPARE_PRACTICE_QUESTION_TYPE)
        binding.tvPrepareTitle.text = when (type) {
            "LOTS" -> {
                val formattedText = Html.fromHtml(
                    "Latihan Soal <font color='#199425'>LOTS</font> Segitiga dan Segi Empat akan dilaksanakan dalam waktu 15 menit, terdiri atas 5 soal pilihan ganda.",
                    Html.FROM_HTML_MODE_LEGACY
                )
                formattedText
            }

            "MOTS" -> {
                val formattedText = Html.fromHtml(
                    "Latihan Soal <font color='#D6AB13'>MOTS</font> Segitiga dan Segi Empat akan dilaksanakan dalam waktu 15 menit, terdiri atas 5 soal pilihan ganda.",
                    Html.FROM_HTML_MODE_LEGACY
                )
                formattedText
            }

            "HOTS" -> {
                val formattedText = Html.fromHtml(
                    "Latihan Soal <font color='#D61313'>HOTS</font> Segitiga dan Segi Empat akan dilaksanakan dalam waktu 15 menit, terdiri atas 5 soal pilihan ganda.",
                    Html.FROM_HTML_MODE_LEGACY
                )
                formattedText
            }

            else -> {
                ""
            }
        }
    }

    private fun initButton() {
        binding.goButton.setOnClickListener {
            val type = intent.getStringExtra(PREPARE_PRACTICE_QUESTION_TYPE)

            val intent = Intent(this, PracticeQuestionQuizActivity::class.java)
            intent.putExtra(PREPARE_PRACTICE_QUESTION_TYPE, type)
            startActivity(intent)
            finish()
        }
    }
}