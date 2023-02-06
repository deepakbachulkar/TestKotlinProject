package com.example.myapplication.coroutine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModelCoroutine : ViewModel() {
    init {
        viewModelScope.launch {  }
    }
}