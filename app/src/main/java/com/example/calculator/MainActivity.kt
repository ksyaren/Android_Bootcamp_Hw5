package com.example.calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentNumber = ""
    private var result = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sayı butonları için listener tanımla
        val numberButtons = listOf(
            binding.btn0, binding.btn1, binding.btn2, binding.btn3, binding.btn4,
            binding.btn5, binding.btn6, binding.btn7, binding.btn8, binding.btn9
        )

        numberButtons.forEach { button ->
            button.setOnClickListener {
                currentNumber += button.text
                binding.resultText.text = currentNumber
            }
        }

        // + butonu
        binding.btnAdd.setOnClickListener {
            if (currentNumber.isNotEmpty()) {
                result += currentNumber.toInt()
                currentNumber = ""
                binding.resultText.text = result.toString()
            }
        }

        // = butonu
        binding.btnEqual.setOnClickListener {
            if (currentNumber.isNotEmpty()) {
                result += currentNumber.toInt()
                currentNumber = ""
            }
            binding.resultText.text = result.toString()
        }

        // C (clear) butonu
        binding.btnClear.setOnClickListener {
            currentNumber = ""
            result = 0
            binding.resultText.text = "0"
        }
    }
}
