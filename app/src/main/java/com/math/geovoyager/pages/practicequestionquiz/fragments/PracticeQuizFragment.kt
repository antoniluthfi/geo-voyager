package com.math.geovoyager.pages.practicequestionquiz.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.math.geovoyager.databinding.FragmentPracticeQuizBinding
import com.math.geovoyager.pages.practicequestionquiz.adapters.RvAnswerButtonListAdapter
import com.math.geovoyager.pages.practicequestionquiz.models.PracticeQuizFragmentInterface
import com.math.geovoyager.pages.practicequestionquiz.models.QuestionData
import com.math.geovoyager.pages.practicequestionquiz.models.RecordAnswerData
import com.math.geovoyager.pages.practicequestionquiz.viewmodels.PracticeQuestionQuizViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PracticeQuizFragment : Fragment(), PracticeQuizFragmentInterface {
    private var binding: FragmentPracticeQuizBinding? = null
    private val viewModel: PracticeQuestionQuizViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPracticeQuizBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelObserver()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun onItemClicked(position: Int) {
        val answer = RecordAnswerData(
            viewModel.currentQuestion.value!!.number,
            position,
            viewModel.currentQuestion.value!!.answers[position].isCorrect,
            getScore(viewModel.currentQuestion.value!!.answers[position].isCorrect)
        )
        viewModel.setRecordAnswer(viewModel.currentQuestion.value!!.number - 1, answer)
    }

    private fun viewModelObserver() {
        viewModel.currentQuestion.observe(viewLifecycleOwner) { item ->
            initLayout(item)
        }
    }

    private fun initLayout(item: QuestionData) {
        binding?.tvQuestion?.text = item.question
        binding?.questionImage?.apply {
            item.image?.let { setImageResource(it) }
            visibility = if (item.image != null) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

        binding?.rvAnswers?.adapter =
            RvAnswerButtonListAdapter(item.answers, this)
        binding?.rvAnswers?.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun getScore(isCorrect: Boolean): Int {
        val score = 100 / viewModel.questions.value?.size!!
        if (isCorrect) {
            return score
        }

        return 0
    }
}