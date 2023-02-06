package com.example.myapplication.fragment

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R

class FragmentMainActivity : AppCompatActivity() {
     lateinit var viewModel: MainViewModel
     lateinit var context: Context
    private val customFragmentFactory = Fragment2Factory(this, "Default fragment 2/3 text")

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = customFragmentFactory
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_main)
        context = this;
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, Fragment1.newInstance())
                .commitNow()
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container2, Fragment2::class.java, null)
//                .add(R.id.container2, Fragment2.newInstance(this , "dta"))
                .commitNow()
        }

       viewModel.stringMLD.observe(context as FragmentMainActivity) {
           Log.d("MY_APP", "Fragment view model string")
       }
    }
}