package com.example.custombutton

import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.custombutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isButtonPressed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonPressed.setOnClickListener {
            isButtonPressed = !isButtonPressed
            if (isButtonPressed) {
                binding.buttonPressed.text = "ON"
                binding.buttonPressed.setTextColor(getColor(R.color.green))
                animatedProgressBar(binding.progressBar, 0, 100)
            } else {
                binding.buttonPressed.text = "OFF"
                binding.buttonPressed.setTextColor(getColor(R.color.gray))
                animatedProgressBar(binding.progressBar, 100, 0)
            }
        }

    }

    private fun animatedProgressBar(progressBar: ProgressBar, start: Int, end: Int) {
        val progressAnimator = ObjectAnimator.ofInt(progressBar, "progress", start, end)
        progressAnimator.duration = 1000
        progressAnimator.start()
    }
}