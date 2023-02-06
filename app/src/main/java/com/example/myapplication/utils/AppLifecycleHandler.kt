package com.example.myapplication.utils

import android.app.Activity
import android.app.Application
import android.content.ComponentCallbacks2
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log

// Take an instance of our lifecycleHandler as a constructor parameter
class AppLifecycleHandler(private val lifecycleDelegate: LifecycleDelegate)
    : Application.ActivityLifecycleCallbacks, ComponentCallbacks2 // <-- Implement these
{
    val TAG = "MY_APP_AppLifecycleHandler"
    private var appInForeground = false
    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        p0.let {
            if(it.componentName.shortClassName.equals(".MainActivity")) {
                lifecycleDelegate.onAppOpen()
                Log.d(TAG, "onActivityCreated ${it.componentName.shortClassName}")
            }
        }
    }

    override fun onActivityStarted(p0: Activity) {
        Log.d(TAG,"onActivityStarted")
    }

    // Override from Application.ActivityLifecycleCallbacks
    override fun onActivityResumed(p0: Activity) {
        if (!appInForeground) {
            appInForeground = true
            lifecycleDelegate.onAppForegrounded()
        }
        Log.d(TAG,"onActivityResumed")
    }

    override fun onActivityPaused(p0: Activity) {
        Log.d(TAG,"onActivityPaused")
    }

    override fun onActivityStopped(p0: Activity) {
        p0?.let {
            if(it.componentName.shortClassName.equals(".MainActivity")) {
                lifecycleDelegate.onAppClose()
                Log.d(TAG, "onActivityStopped ${it.componentName.shortClassName}")
            }
        }
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        Log.d(TAG,"onConfigurationChanged")
    }

    override fun onActivityDestroyed(p0: Activity) {
        Log.d(TAG,"onActivitySaveInstanceState")
    }

    override fun onConfigurationChanged(p0: Configuration) {
        Log.d(TAG,"onConfigurationChanged")
    }

    override fun onLowMemory() {
        Log.d(TAG,"onLowMemory")
    }

    // Override from ComponentCallbacks2
    override fun onTrimMemory(level: Int) {
        if (level == ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
            appInForeground = false
            // lifecycleDelegate instance was passed in on the constructor
            lifecycleDelegate.onAppBackgrounded()
        }
        Log.d(TAG,"onTrimMemory")
    }
}