package com.example.myapplication.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EdgeEffect
import android.widget.EditText
import com.example.myapplication.R

class Fragment1 : Fragment() {
    lateinit var v:View
    lateinit var editText:EditText
    companion object {
        fun newInstance() = Fragment1()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
             // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        v = inflater.inflate(R.layout.fragment_main, container, false)
        editText = v.findViewById(R.id.edit_text)

        v.findViewById<Button>(R.id.next).setOnClickListener {
            (context as FragmentMainActivity).viewModel.setStringData(editText.text.toString())
        }
        return v;
    }

}