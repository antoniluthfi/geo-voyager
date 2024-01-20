package com.math.geovoyager.pages.practicequestionquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.math.geovoyager.R
import com.math.geovoyager.databinding.ActivityPracticeQuestionQuizBinding
import com.math.geovoyager.pages.practicequestionquiz.adapters.RvNumberQuestionButtonListAdapter
import com.math.geovoyager.pages.practicequestionquiz.fragments.PracticeQuizFragment
import com.math.geovoyager.pages.practicequestionquiz.models.PracticeQuestionQuizInterface
import com.math.geovoyager.pages.practicequestionquiz.models.QuestionData
import com.math.geovoyager.pages.practicequestionquiz.viewmodels.PracticeQuestionQuizViewModel
import com.math.geovoyager.pages.practicequestionresult.PracticeQuestionResultActivity
import com.math.geovoyager.utils.Constants.FINAL_SCORE
import com.math.geovoyager.utils.Constants.PREPARE_PRACTICE_QUESTION_TYPE
import com.math.geovoyager.utils.Constants.TOTAL_CORRECT
import com.math.geovoyager.utils.Constants.TOTAL_INCORRECT
import com.math.geovoyager.utils.Constants.TOTAL_QUESTION
import com.math.geovoyager.utils.GlobalPopup.showConfirmationPopup
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PracticeQuestionQuizActivity : AppCompatActivity(), PracticeQuestionQuizInterface {
    private lateinit var binding: ActivityPracticeQuestionQuizBinding
    private val viewModel: PracticeQuestionQuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPracticeQuestionQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTopBar()
        initQuestions()
        initQuizFragment()
        viewModelObserver()
        initFinishExerciseButton()
    }

    @SuppressLint("SetTextI18n")
    override fun onItemClicked(position: Int) {
        binding.customTopBar.tvTopBarTitle.text = "Soal ${position + 1}"
        viewModel.currentQuestion.value = viewModel.questions.value?.get(position)
    }

    @SuppressLint("SetTextI18n")
    private fun initTopBar() {
        binding.customTopBar.ivBack.setOnClickListener {
            finish()
            viewModel.resetState()
        }

        binding.customTopBar.tvTopBarTitle.text = "Soal 1"
    }

    private fun initQuestions() {
        when (intent.getStringExtra(PREPARE_PRACTICE_QUESTION_TYPE)) {
            "LOTS" -> {
                viewModel.loadLOTSQuestions()
            }

            "MOTS" -> {
                viewModel.loadMOTSQuestions()
            }

            "HOTS" -> {
                viewModel.loadHOTSQuestions()
            }

            else -> {}
        }
    }

    private fun initQuizFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, PracticeQuizFragment())
        fragmentTransaction.commit()
    }

    private fun viewModelObserver() {
        viewModel.questions.observe(this) { items ->
            initNumberQuestionButtonList(items)
        }

        viewModel.recordedAnswers.observe(this) { items ->
            if (items.size == viewModel.questions.value?.size) {
                binding.completeExerciseButton.visibility = View.VISIBLE
            } else {
                binding.completeExerciseButton.visibility = View.GONE
            }
        }
    }

    private fun initNumberQuestionButtonList(items: List<QuestionData>) {
        viewModel.currentQuestion.value = items[0]

        binding.rvNumberQuestionButtonList.adapter =
            RvNumberQuestionButtonListAdapter(this, items, this)
        binding.rvNumberQuestionButtonList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun initFinishExerciseButton() {
        binding.completeExerciseButton.setOnClickListener {
            showConfirmationPopup(
                this,
                layoutInflater,
                "Apakah anda yakin ingin menyelesaikan latihan?",
            ) {
                val totalScores = viewModel.recordedAnswers.value?.sumOf { it.score }
                val totalCorrect = viewModel.recordedAnswers.value?.count { it.isCorrect }
                val totalIncorrect = viewModel.recordedAnswers.value?.count { !it.isCorrect }
                val totalQuestion = viewModel.questions.value?.size
                val type = intent.getStringExtra(PREPARE_PRACTICE_QUESTION_TYPE)

                val intent = Intent(this, PracticeQuestionResultActivity::class.java)
                intent.putExtra(FINAL_SCORE, totalScores.toString())
                intent.putExtra(TOTAL_QUESTION, totalQuestion.toString())
                intent.putExtra(TOTAL_CORRECT, totalCorrect.toString())
                intent.putExtra(TOTAL_INCORRECT, totalIncorrect.toString())
                intent.putExtra(PREPARE_PRACTICE_QUESTION_TYPE, type)
                startActivity(intent)
                viewModel.resetState()

                finish()
            }
        }
    }
}