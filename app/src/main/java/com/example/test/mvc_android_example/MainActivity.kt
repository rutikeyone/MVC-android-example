package com.example.test.mvc_android_example

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.test.mvc_android_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val counter = Counter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        updateCountText()
        with(binding) {
            incrementButton.setOnClickListener {
                counter.increment()
                updateCountText()
            }

            decrementButton.setOnClickListener {
                counter.decrement()
                updateCountText()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateCountText() {
        binding.countTextView.text = counter.count.toString()
    }
}