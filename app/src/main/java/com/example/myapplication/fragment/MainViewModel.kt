package com.example.myapplication.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val stringMLD:MutableLiveData<String> = MutableLiveData("Default");

    fun setStringData(data:String){
        stringMLD.value = data
    }

    fun getStringData():String{
         stringMLD.value?.let {
             return it
         }
        return "";
    }
}