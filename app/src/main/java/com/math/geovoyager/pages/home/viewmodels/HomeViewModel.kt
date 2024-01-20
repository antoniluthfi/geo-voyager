package com.math.geovoyager.pages.home.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.math.geovoyager.pages.home.models.MenuData
import com.math.geovoyager.repositories.menu.MenuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: MenuRepository): ViewModel() {
    private val _menu = MutableLiveData<List<MenuData>>()
    val menu: LiveData<List<MenuData>> get() = _menu

    fun loadMenu() {
        viewModelScope.launch {
            _menu.value = repository.getMockData()
        }
    }
}