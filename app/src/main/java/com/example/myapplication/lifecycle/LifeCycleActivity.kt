package com.example.myapplication.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLifeCycleBinding

class LifeCycleActivity : AppCompatActivity() {
    val TAG = "MY_APP"

    private lateinit var binding: ActivityLifeCycleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        binding = ActivityLifeCycleBinding.inflate(layoutInflater)
        lifecycle.addObserver(Observer())
        Log.d(TAG, "Activity onCreate")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Activity onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Activity onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Activity onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Activity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Activity onDestroy")
    }
}