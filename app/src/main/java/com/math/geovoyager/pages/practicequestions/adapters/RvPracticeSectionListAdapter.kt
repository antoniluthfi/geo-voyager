package com.math.geovoyager.pages.practicequestions.adapters

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.math.geovoyager.databinding.PracticequestionsItemBinding
import com.math.geovoyager.pages.practicequestions.models.PracticeQuestionData
import com.math.geovoyager.pages.preparepracticequestion.PreparePracticeQuestionActivity
import com.math.geovoyager.utils.Constants.PREPARE_PRACTICE_QUESTION_TYPE

class RvPracticeSectionListAdapter(
    private val context: Context,
    private val data: List<PracticeQuestionData>
) : RecyclerView.Adapter<RvPracticeSectionListAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: PracticequestionsItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView

        fun bind(data: PracticeQuestionData) {
            with(binding) {
                itemCard.setBackgroundColor(Color.parseColor(data.color))
                tvTitle.text = data.title
                tvDescription.text = data.description

                startButton.apply {
                    strokeColor = ColorStateList.valueOf(Color.parseColor(data.color))
                    setTextColor(Color.parseColor(data.color))

                    setOnClickListener {
                        when(data.title) {
                            "SOAL LOTS" -> {
                                handleNavigation("LOTS")
                            }

                            "SOAL MOTS" -> {
                                handleNavigation("MOTS")
                            }

                            "SOAL HOTS" -> {
                                handleNavigation("HOTS")
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PracticequestionsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    private fun  handleNavigation(type: String) {
        val intent = Intent(context, PreparePracticeQuestionActivity::class.java)
        intent.putExtra(PREPARE_PRACTICE_QUESTION_TYPE, type)
        context.startActivity(intent)
    }
}