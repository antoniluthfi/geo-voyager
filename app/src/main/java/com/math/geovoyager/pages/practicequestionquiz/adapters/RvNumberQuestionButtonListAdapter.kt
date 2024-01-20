package com.math.geovoyager.pages.practicequestionquiz.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.math.geovoyager.databinding.PracticequestionquizNumberQuestionItemBinding
import com.math.geovoyager.pages.practicequestionquiz.models.PracticeQuestionQuizInterface
import com.math.geovoyager.pages.practicequestionquiz.models.QuestionData

class RvNumberQuestionButtonListAdapter(
    private val context: Context,
    private val data: List<QuestionData>,
    private val practiceQuestionQuizInterface: PracticeQuestionQuizInterface
) : RecyclerView.Adapter<RvNumberQuestionButtonListAdapter.ViewHolder>() {

    private var selectedPosition: Int = 0

    inner class ViewHolder(itemView: PracticequestionquizNumberQuestionItemBinding): RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView

        fun bind(data: QuestionData, position: Int) {
            binding.tvNumber.text = data.number.toString()
            binding.numberQuestionButton.isSelected = position == selectedPosition

            binding.numberQuestionButton.setOnClickListener {
                setSelectedPosition(adapterPosition)
                practiceQuestionQuizInterface.onItemClicked(adapterPosition)
            }
        }
    }

    private fun setSelectedPosition(position: Int) {
        if (selectedPosition != position) {
            notifyItemChanged(selectedPosition)
            selectedPosition = position
            notifyItemChanged(selectedPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PracticequestionquizNumberQuestionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], position)
    }
}
