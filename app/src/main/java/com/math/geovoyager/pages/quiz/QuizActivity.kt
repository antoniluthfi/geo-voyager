package com.math.geovoyager.pages.quiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.math.geovoyager.databinding.ActivityQuizBinding
import com.math.geovoyager.pages.quiz.adapters.RvQuizAnswerAdapter
import com.math.geovoyager.pages.quiz.models.AnswerData
import com.math.geovoyager.pages.quiz.models.QuizInterface
import com.math.geovoyager.pages.quiz.viewmodels.QuizViewModel
import com.math.geovoyager.pages.quizresult.QuizResultActivity
import com.math.geovoyager.utils.Constants.CORRECT_ANSWER
import com.math.geovoyager.utils.Constants.IS_CORRECT
import com.math.geovoyager.utils.Constants.QUIZ_INDEX
import com.math.geovoyager.utils.Constants.TOTAL_QUESTIONS
import com.math.geovoyager.utils.GlobalPopup
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizActivity : AppCompatActivity(), QuizInterface {
    private lateinit var binding: ActivityQuizBinding
    private val viewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
        initTopAppBar()
        initQuestion()
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            handleExit()
        }
    }

    override fun onAnswerClick(item: AnswerData) {
        GlobalPopup.showConfirmationPopup(
            this,
            layoutInflater,
            "Apakah anda yakin memilih jawaban ini?",
        ) {
            val quizIndex = intent.getIntExtra(QUIZ_INDEX, 0)
            val currentQuestion = viewModel.questions.value?.get(quizIndex)
            val correctAnswer = currentQuestion?.answers?.find { it.isCorrect }

            val intent = Intent(this, QuizResultActivity::class.java)
            intent.putExtra(QUIZ_INDEX, quizIndex + 1)
            intent.putExtra(IS_CORRECT, item.isCorrect)
            intent.putExtra(CORRECT_ANSWER, correctAnswer?.description)
            intent.putExtra(TOTAL_QUESTIONS, viewModel.questions.value?.size)
            startActivity(intent)

            finish()
        }
    }

    private fun initTopAppBar() {
        binding.customTopBar.ivBack.setOnClickListener {
            handleExit()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initQuestion() {
        val quizIndex = intent.getIntExtra(QUIZ_INDEX, 0)
        viewModel.questions.observe(this) { items ->
            val currentQuestion = items[quizIndex]

            with(binding) {
                customTopBar.tvQuestionNumber.text = "Pertanyaan ${currentQuestion.number}"
                tvQuestion.text = currentQuestion.question

                if (currentQuestion.image != null) {
                    questionImage.setImageResource(currentQuestion.image)
                    questionImage.visibility = View.VISIBLE
                }

                rvAnswers.adapter = RvQuizAnswerAdapter(currentQuestion.answers, this@QuizActivity)
                rvAnswers.layoutManager = LinearLayoutManager(this@QuizActivity)
            }
        }

        viewModel.loadQuestions()
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