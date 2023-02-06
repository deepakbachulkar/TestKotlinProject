package com.example.myapplication.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.myapplication.ListenActivities

class UninstallIntentReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent) {
        // fetching package names from extras
        val packageNames = intent.getStringArrayExtra("android.intent.extra.PACKAGES")
        if (packageNames != null) {
            for (packageName in packageNames) {
                if (packageName == "com.example.myapplication") {
                    // User has selected our application under the Manage Apps settings
                    // now initiating background thread to watch for activity
                    ListenActivities(context).start()
                }
            }
        }
    }
}