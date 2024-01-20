package com.math.geovoyager.pages.practicequestionquiz.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.math.geovoyager.databinding.PracticequestionquizAnswerItemBinding
import com.math.geovoyager.pages.practicequestionquiz.models.AnswerData
import com.math.geovoyager.pages.practicequestionquiz.models.PracticeQuizFragmentInterface

class RvAnswerButtonListAdapter(
    private val data: List<AnswerData>,
    private val practiceQuizFragmentInterface: PracticeQuizFragmentInterface,
) : RecyclerView.Adapter<RvAnswerButtonListAdapter.ViewHolder>() {

    private var selectedPosition = RecyclerView.NO_POSITION

    inner class ViewHolder(itemView: PracticequestionquizAnswerItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView

        fun bind(data: AnswerData, position: Int) {
            binding.tvAnswer.text = data.description

            binding.answerButton.isSelected = position == selectedPosition

            binding.answerButton.setOnClickListener {
                setSelectedPosition(adapterPosition)
                practiceQuizFragmentInterface.onItemClicked(adapterPosition)
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
        return ViewHolder(
            PracticequestionquizAnswerItemBinding.inflate(
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
        holder.bind(data[position], position)
    }
}
