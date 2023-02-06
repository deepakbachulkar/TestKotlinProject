package com.example.myapplication.viewmodel_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelMain(private val initValue:Int) : ViewModel() {
    var count:Int = initValue

    fun increment(){
        count++
    }

    private val myLiveDataObject = MutableLiveData<String>( "Update Count: $count")

    val myLiveData : LiveData<String>
    get() = myLiveDataObject

    fun updateLiveData(){
        myLiveDataObject.value = "Update Count: $count"
    }
}