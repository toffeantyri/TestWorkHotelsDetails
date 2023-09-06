package com.testwork.hotels

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.testwork.hotels.databinding.MainActivityBinding

const val TAG = "LOG_TAG"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}


