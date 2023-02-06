package com.example.myapplication.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.LifecycleOwner

class Fragment2Factory(private val owner: LifecycleOwner, private val data:String): FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        if (className == Fragment2::class.java.name) {
            return Fragment2(owner, data)
        }
        return super.instantiate(classLoader, className)
    }
}