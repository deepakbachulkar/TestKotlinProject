package com.example.myapplication

import android.app.Application
import android.util.Log
import com.example.myapplication.utils.AppLifecycleHandler
import com.example.myapplication.utils.LifecycleDelegate

class MyApplication: Application(), LifecycleDelegate {
    val TAG = "MY_APP_Application"
    override fun onCreate() {
        super.onCreate()
        val lifeCycleHandler = AppLifecycleHandler(this)
        registerLifecycleHandler(lifeCycleHandler)
        Log.d(TAG, "Application on create")
    }

    override fun onAppBackgrounded() {
        Log.d(TAG, "App in background")
    }

    override fun onAppForegrounded() {
        Log.d(TAG, "App in foreground")
    }

    override fun onAppOpen() {
        Log.d(TAG, "App is open")
    }

    override fun onAppClose() {
        Log.d(TAG, "App is close")
    }
    private fun registerLifecycleHandler(lifeCycleHandler: AppLifecycleHandler) {
        registerActivityLifecycleCallbacks(lifeCycleHandler)
        registerComponentCallbacks(lifeCycleHandler)
    }
}