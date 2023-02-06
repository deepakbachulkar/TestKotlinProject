package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import com.example.myapplication.coroutine.CoroutineActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.fragment.FragmentMainActivity
import com.example.myapplication.lifecycle.LifeCycleActivity
import com.example.myapplication.utils.LaptopBuilder
import com.example.myapplication.viewmodel_livedata.ViewModelLiveDataActivity

class MainActivity : AppCompatActivity(), OnClickListener {
    val TAG = "MY_APP"

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)

        binding.coroutine.setOnClickListener(this)
        binding.lifecycleAware.setOnClickListener(this)
        binding.viewModelLiveData.setOnClickListener(this)
        binding.fragmentDemo.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.coroutine.id -> {
                Log.d(TAG, "Call coroutine")
                startActivity(CoroutineActivity())
            }
            binding.lifecycleAware.id -> {
                Log.d(TAG, "Life Cycle Aware")
                startActivity(LifeCycleActivity())
            }
            binding.viewModelLiveData.id -> {
                Log.d(TAG, "View Model")
                startActivity(ViewModelLiveDataActivity())
            }
            binding.fragmentDemo.id -> {
                Log.d(TAG, "Fragment Demo")
                startActivity(FragmentMainActivity())
            }
        }

//  Example Builder object.
        val d= LaptopBuilder.Builder("MacPro")
            .setRam("16GB")
            .setBattery("1000MG")
            .setScreenSize("1600*1000").create()
        Log.d(TAG, "Data Laptop: ${d}")
    }

    private fun startActivity(activity: AppCompatActivity){
        // start your activity by passing the intent
        val intent = Intent(this, activity::class.java)
        startActivity( intent)
    }

}