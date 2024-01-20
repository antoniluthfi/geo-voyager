package com.math.geovoyager.pages.quiz.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.math.geovoyager.pages.quiz.models.QuizData
import com.math.geovoyager.repositories.quiz.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(private val repository: QuizRepository) : ViewModel() {
    private val _questions = MutableLiveData<List<QuizData>>()
    val questions: LiveData<List<QuizData>> get() = _questions

    fun loadQuestions() {
        _questions.value = repository.getQuestions()
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}