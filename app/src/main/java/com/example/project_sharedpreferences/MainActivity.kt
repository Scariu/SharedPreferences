package com.example.project_sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project_sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        binding.buttonGuardar.setOnClickListener{
            val entero = binding.editTextNumber.text.toString().toInt()
            val texto = binding.editTextTexto.text.toString()
            val decimal = binding.editTextNumberDecimal.text.toString().toInt()
            val switch = binding.switchHello.isChecked
        }
    }
}