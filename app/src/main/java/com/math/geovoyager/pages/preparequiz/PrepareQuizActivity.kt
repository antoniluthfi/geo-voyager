package com.math.geovoyager.pages.preparequiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.math.geovoyager.databinding.ActivityPrepareQuizBinding
import com.math.geovoyager.pages.quiz.QuizActivity
import com.math.geovoyager.utils.Constants.QUIZ_INDEX
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PrepareQuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrepareQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrepareQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTopBar()
        initStartButton()
    }

    @SuppressLint("SetTextI18n")
    private fun initTopBar() {
        binding.customTopBar.ivBack.setOnClickListener {
            finish()
        }
        binding.customTopBar.tvTopBarTitle.text = "Quiz"
    }

    private fun initStartButton() {
        binding.startButton.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra(QUIZ_INDEX, 0)
            startActivity(intent)
            finish()
        }
    }
}