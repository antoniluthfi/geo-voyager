package com.math.geovoyager.pages.practicequestionquiz.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.math.geovoyager.pages.practicequestionquiz.models.QuestionData
import com.math.geovoyager.pages.practicequestionquiz.models.RecordAnswerData
import com.math.geovoyager.repositories.practicequestionquiz.PracticeQuestionQuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import javax.inject.Inject

@HiltViewModel
class PracticeQuestionQuizViewModel @Inject constructor(
    private val repository: PracticeQuestionQuizRepository
) : ViewModel() {
    private val _questions = MutableLiveData<List<QuestionData>>()
    val questions: LiveData<List<QuestionData>> get() = _questions

    val currentQuestion = MutableLiveData<QuestionData>()

    private val _recordedAnswers = MutableLiveData<List<RecordAnswerData>>()
    val recordedAnswers: LiveData<List<RecordAnswerData>> get() = _recordedAnswers

    fun loadLOTSQuestions() {
        _questions.value = repository.getLOTSQuestions()
    }

    fun loadMOTSQuestions() {
        _questions.value = repository.getMOTSQuestions()
    }

    fun loadHOTSQuestions() {
        _questions.value = repository.getHOTSQuestions()
    }

    fun setRecordAnswer(index: Int, recordAnswer: RecordAnswerData) {
        val currentList = _recordedAnswers.value.orEmpty().toMutableList()

        if (index in 0 until currentList.size) {
            currentList[index] = recordAnswer
        } else {
            currentList.add(recordAnswer)
        }

        _recordedAnswers.value = currentList
    }

    fun resetState() {
        _recordedAnswers.value = emptyList()
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}