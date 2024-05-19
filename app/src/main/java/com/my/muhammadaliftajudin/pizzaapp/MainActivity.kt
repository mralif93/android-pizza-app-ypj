package com.my.muhammadaliftajudin.pizzaapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.my.muhammadaliftajudin.pizzaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Order Button
        binding.orderBtn.setOnClickListener {
            var pizzaSizePrice = 0.0
            var toppingsTotal = 0.0

            when {
                binding.smallRadioBtn.isChecked -> pizzaSizePrice = 5.0
                binding.mediumRadioBtn.isChecked -> pizzaSizePrice = 7.0
                binding.bigRadioBtn.isChecked -> pizzaSizePrice = 9.0
            }

            if (binding.onionsChkBtn.isChecked) {
                toppingsTotal += 1
            }

            if (binding.olivesChkBtn.isChecked) {
                toppingsTotal += 2
            }

            if (binding.tomatoesChkBtn.isChecked) {
                toppingsTotal += 3
            }

            binding.totalTextView.text = "Total Order Price = RM ${pizzaSizePrice + toppingsTotal}"
        }
    }
}