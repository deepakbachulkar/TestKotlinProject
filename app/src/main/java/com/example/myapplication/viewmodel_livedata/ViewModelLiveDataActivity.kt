package com.example.myapplication.viewmodel_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityViewModelBinding

class ViewModelLiveDataActivity : AppCompatActivity() {
    lateinit var viewModelMain:ViewModelMain
    lateinit var binding: ActivityViewModelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModelMain = ViewModelProvider(this, ViewModelMainFactory(10)).get(ViewModelMain::class.java)
        binding.increment.setOnClickListener {
            increment()
            viewModelMain.updateLiveData()
        }
        setText()


        viewModelMain.myLiveData.observe(this, Observer {
            it?.let {
                binding.liveDataText.text = it
            }
        })

    }

    private fun setText(){
        binding.text.text = "${viewModelMain.count}"
    }

    private fun increment(){
        viewModelMain.increment()
        setText()
    }
}