package com.math.geovoyager.pages.practicequestionresult

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.math.geovoyager.R
import com.math.geovoyager.databinding.ActivityPracticeQuestionResultBinding
import com.math.geovoyager.pages.practicequestionanswerkey.PracticeQuestionAnswerKeyActivity
import com.math.geovoyager.pages.preparepracticequestion.PreparePracticeQuestionActivity
import com.math.geovoyager.utils.Constants.FINAL_SCORE
import com.math.geovoyager.utils.Constants.PREPARE_PRACTICE_QUESTION_TYPE
import com.math.geovoyager.utils.Constants.TOTAL_CORRECT
import com.math.geovoyager.utils.Constants.TOTAL_INCORRECT
import com.math.geovoyager.utils.Constants.TOTAL_QUESTION
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PracticeQuestionResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPracticeQuestionResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPracticeQuestionResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTopBar()
        initSummary()
        initRestartButton()
        initAnswerKeyButton()
    }

    @SuppressLint("SetTextI18n")
    private fun initTopBar() {
        binding.customTopBar.ivBack.setOnClickListener {
            finish()
        }

        binding.customTopBar.tvTopBarTitle.text = "Hasil"
    }

    private fun initSummary() {
        val totalScores = intent.getStringExtra(FINAL_SCORE)
        val totalCorrect = intent.getStringExtra(TOTAL_CORRECT)
        val totalIncorrect = intent.getStringExtra(TOTAL_INCORRECT)
        val totalQuestions = intent.getStringExtra(TOTAL_QUESTION)

        val label = when (totalScores?.toInt()) {
            in 91..100 -> {
                binding.tvScore.setTextColor(resources.getColor(R.color.light_green))
                binding.tvScoreDescription.setTextColor(resources.getColor(R.color.light_green))
                "GOOD JOB!!!"
            }

            in 80..90 -> {
                binding.tvScore.setTextColor(resources.getColor(R.color.light_green))
                binding.tvScoreDescription.setTextColor(resources.getColor(R.color.light_green))
                "Pertahankan!!!"
            }

            in 60..79 -> {
                binding.tvScore.setTextColor(resources.getColor(R.color.gold))
                binding.tvScoreDescription.setTextColor(resources.getColor(R.color.gold))
                "Ayo tingkatkan lagi!"
            }

            in 40..59 -> {
                binding.tvScore.setTextColor(resources.getColor(R.color.red))
                binding.tvScoreDescription.setTextColor(resources.getColor(R.color.red))
                "Ayo belajar lebih giat lagi!"
            }

            else -> {
                binding.tvScore.setTextColor(resources.getColor(R.color.red))
                binding.tvScoreDescription.setTextColor(resources.getColor(R.color.red))
                "Ayo semangat lagi belajarnya!! coba lagi ya!!!"
            }
        }

        binding.tvScore.text = totalScores
        binding.tvScoreDescription.text = label
        binding.tvTotalQuestion.text = totalQuestions
        binding.tvTotalCorrect.text = totalCorrect
        binding.tvTotalIncorrect.text = totalIncorrect
    }

    private fun initRestartButton() {
        binding.restartButton.setOnClickListener {
            val type = intent.getStringExtra(PREPARE_PRACTICE_QUESTION_TYPE)
            val intent = Intent(this, PreparePracticeQuestionActivity::class.java)
            intent.putExtra(PREPARE_PRACTICE_QUESTION_TYPE, type)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }

    private fun initAnswerKeyButton() {
        binding.answerKeyButton.setOnClickListener {
            val type = intent.getStringExtra(PREPARE_PRACTICE_QUESTION_TYPE)
            val intent = Intent(this, PracticeQuestionAnswerKeyActivity::class.java)
            intent.putExtra(PREPARE_PRACTICE_QUESTION_TYPE, type)
            startActivity(intent)
        }
    }
}