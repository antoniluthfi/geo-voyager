package com.math.geovoyager.pages.quizresult

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.math.geovoyager.R
import com.math.geovoyager.databinding.ActivityQuizResultBinding
import com.math.geovoyager.pages.quiz.QuizActivity
import com.math.geovoyager.utils.Constants.CORRECT_ANSWER
import com.math.geovoyager.utils.Constants.IS_CORRECT
import com.math.geovoyager.utils.Constants.QUIZ_INDEX
import com.math.geovoyager.utils.Constants.TOTAL_QUESTIONS
import com.math.geovoyager.utils.GlobalPopup
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
        initTopAppBar()
        initAnswer()
        initButtonNextQuestion()
        initButtonExit()
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val quizIndex = intent.getIntExtra(QUIZ_INDEX, 0)
            val totalQuestions = intent.getIntExtra(TOTAL_QUESTIONS, 1)

            if (quizIndex == totalQuestions) {
                finish()
            } else {
                handleExit()
            }
        }
    }

    private fun initTopAppBar() {
        val quizIndex = intent.getIntExtra(QUIZ_INDEX, 0)
        val totalQuestions = intent.getIntExtra(TOTAL_QUESTIONS, 1)

        binding.ivBack.setOnClickListener {
            if (quizIndex == totalQuestions) {
                finish()
            } else {
                handleExit()
            }
        }
    }

    private fun initAnswer() {
        val quizIndex = intent.getIntExtra(QUIZ_INDEX, 0)
        val isCorrect = intent.getBooleanExtra(IS_CORRECT, false)
        val correctAnswer = intent.getStringExtra(CORRECT_ANSWER)
        val totalQuestions = intent.getIntExtra(TOTAL_QUESTIONS, 1)

        with(binding) {
            tvAnswer.text = correctAnswer
            if (isCorrect) {
                tvStatementResult.text = "Benar"
                quizImage.setImageResource(R.drawable.ic_quiz_correct)
            } else {
                tvStatementResult.text = "Salah"
                quizImage.setImageResource(R.drawable.ic_quiz_incorrect)
            }

            if (quizIndex == totalQuestions) {
                nextQuestionButton.visibility = View.GONE
            } else {
                nextQuestionButton.visibility = View.VISIBLE
            }
        }
    }

    private fun initButtonNextQuestion() {
        val quizIndex = intent.getIntExtra(QUIZ_INDEX, 0)
        val totalQuestions = intent.getIntExtra(TOTAL_QUESTIONS, 1)

        binding.nextQuestionButton.setOnClickListener {
            if (quizIndex < totalQuestions) {
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra(QUIZ_INDEX, quizIndex)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun initButtonExit() {
        val quizIndex = intent.getIntExtra(QUIZ_INDEX, 0)
        val totalQuestions = intent.getIntExtra(TOTAL_QUESTIONS, 1)

        binding.quitButton.setOnClickListener {
            if (quizIndex == totalQuestions) {
                finish()
            } else {
                handleExit()
            }
        }
    }

    private fun handleExit() {
        GlobalPopup.showConfirmationPopup(
            this,
            layoutInflater,
            "Apakah anda yakin tidak ingin melanjutkan quiz?",
        ) {
            finish()
        }
    }
}