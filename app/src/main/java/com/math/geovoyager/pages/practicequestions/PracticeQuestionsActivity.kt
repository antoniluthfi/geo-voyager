package com.math.geovoyager.pages.practicequestions

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.math.geovoyager.databinding.ActivityPracticeQuestionsBinding
import com.math.geovoyager.pages.practicequestions.adapters.RvPracticeSectionListAdapter
import com.math.geovoyager.pages.practicequestions.viewmodels.PracticeQuestionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PracticeQuestionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPracticeQuestionsBinding
    private val viewModel: PracticeQuestionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPracticeQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTopBar()
        initList()
    }

    @SuppressLint("SetTextI18n")
    private fun initTopBar() {
        binding.customTopBar.ivBack.setOnClickListener {
            finish()
        }
        binding.customTopBar.tvTopBarTitle.text = "Latihan Soal"
    }

    private fun initList() {
        viewModel.items.observe(this) { items ->
            binding.rvPracticeSectionList.adapter = RvPracticeSectionListAdapter(this, items)
            binding.rvPracticeSectionList.layoutManager = LinearLayoutManager(this)
        }

        viewModel.loadData()
    }
}