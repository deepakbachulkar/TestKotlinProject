package com.example.myapplication.viewmodel_livedata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelMainFactory(val counter:Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelMain(counter) as T
    }
}