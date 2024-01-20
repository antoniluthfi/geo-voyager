package com.math.geovoyager.pages.practicequestions.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.math.geovoyager.pages.practicequestions.models.PracticeQuestionData
import com.math.geovoyager.repositories.practicequestion.PracticeQuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PracticeQuestionViewModel @Inject constructor(private val repository: PracticeQuestionRepository): ViewModel() {
    private val _items = MutableLiveData<List<PracticeQuestionData>>()
    val items: LiveData<List<PracticeQuestionData>> get() = _items

    fun loadData() {
        viewModelScope.launch {
            _items.value = repository.getMockData()
        }
    }
}