package com.example.myapplication.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import com.example.myapplication.R

class Fragment2(private val owner: LifecycleOwner, private val data:String) : Fragment() {
    lateinit var v:View
    val TAG: String = "MY_APP"
    lateinit var textView: TextView

    companion object {
        fun newInstance( owner: LifecycleOwner, data:String) = Fragment2(owner, data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        v = inflater.inflate(R.layout.fragment_2, container, false)
        textView =  v.findViewById(R.id.message2)
        Log.d(TAG, "Fragment 2 data ${data}")
        ((activity as FragmentMainActivity).viewModel.stringMLD
            .observe(owner) {
            Log.d("MY_APP", "Fragment 2 view model string")
                textView.text= it
        })
        Handler().postDelayed({
            textView.text = data
        }, 100)
        return v
    }

}