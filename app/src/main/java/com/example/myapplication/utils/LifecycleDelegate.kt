package com.example.myapplication.utils

interface LifecycleDelegate {
    fun onAppBackgrounded()
    fun onAppForegrounded()
    fun onAppClose()
    fun onAppOpen()
}