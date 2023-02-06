package com.example.myapplication.coroutine

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.FragmentFirstBinding
import kotlinx.coroutines.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        Log.d("COROUTINE", "${Thread.currentThread().name}")

        return binding.root

    }
    private fun updateCounter(){
        binding.textviewFirst.text = "${binding.textviewFirst.text.toString().toInt() + 1}"
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            updateCounter()
            executeLongTask()
        }

        GlobalScope.launch {
            Log.d("Coroutine", "2: ${Thread.currentThread()}")
            for(i in 0 .. 10000000){
                Log.d("Coroutine", " Coroutine $i")
            }
        }
    }

    private fun executeLongTask(){
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("Coroutine", "1: ${Thread.currentThread()}")
        }

        MainScope().launch {
            Log.d("Coroutine", "3 ${Thread.currentThread()}")
        }

        lifecycleScope.launch {

        }
    }

    suspend fun task1(){
        Log.d("Coroutine", "Task 1")
    }

    suspend fun task2(){
        Log.d("Coroutine", "Task 2")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}