package com.math.geovoyager.pages.quiz.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.math.geovoyager.databinding.QuizAnswerItemBinding
import com.math.geovoyager.pages.quiz.models.AnswerData
import com.math.geovoyager.pages.quiz.models.QuizInterface

class RvQuizAnswerAdapter(
    private val data: List<AnswerData>,
    private val quizInterface: QuizInterface
) :
    RecyclerView.Adapter<RvQuizAnswerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: QuizAnswerItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView

        fun bind(data: AnswerData, position: Int) {
            with(binding) {
                if (position % 2 == 0) {
                    leftAnswerContainer.visibility = View.VISIBLE
                    rightAnswerContainer.visibility = View.GONE

                    tvLeftAnswer.text = data.description
                    leftAnswerContainer.setOnClickListener {
                        quizInterface.onAnswerClick(data)
                    }
                } else {
                    leftAnswerContainer.visibility = View.GONE
                    rightAnswerContainer.visibility = View.VISIBLE

                    tvRightAnswer.text = data.description
                    rightAnswerContainer.setOnClickListener {
                        quizInterface.onAnswerClick(data)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RvQuizAnswerAdapter.ViewHolder {
        return ViewHolder(
            QuizAnswerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
