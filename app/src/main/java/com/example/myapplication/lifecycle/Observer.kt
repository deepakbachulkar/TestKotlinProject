package com.example.myapplication.lifecycle

import android.util.Log
import androidx.lifecycle.*

class Observer: DefaultLifecycleObserver {
    private val TAG = "MY_APP"
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d(TAG, "Observer - ON CREATE")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d(TAG, "Observer - ON RESUME")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d(TAG, "Observer - ON START")
    }
    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d(TAG, "Observer - ON PAUSE")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d(TAG, "Observer - ON STOP")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d(TAG, "Observer - ON DESTROY")
    }
}