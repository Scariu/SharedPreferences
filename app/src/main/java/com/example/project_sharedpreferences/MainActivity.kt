package com.example.project_sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project_sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mSharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        mSharedPreferences = getSharedPreferences("cookie", Context.MODE_PRIVATE)
        binding.buttonGuardar.setOnClickListener{
            val entero = binding.editTextNumber.text.toString().toInt()
            val texto = binding.editTextTexto.text.toString()
            val decimal = binding.editTextNumberDecimal.text.toString().toFloat()
            val switchBoleano = binding.switchHello.isChecked

            guardarDatos(texto, entero, decimal, switchBoleano)
        }

        binding.buttonMostrar.setOnClickListener{
            mostrarDatos()
        }
    }

    private fun mostrarDatos() {
        val entero = mSharedPreferences.getInt("miEntero",0)
        val texto = mSharedPreferences.getString("miTexto", "")
        val decimal = mSharedPreferences.getFloat("miDecimal", 0.0F)
        val switchBoleano = mSharedPreferences.getBoolean("miSitchBooleano", false)

        binding.textViewNumero.text = entero.toString()
        binding.textViewTextoTexto.text = texto
        binding.textViewDecimal.text = decimal.toString()
        binding.textViewHello.text = switchBoleano.toString()
        binding.switchHello.isChecked = switchBoleano
    }

    //Guarda datos en sharedPreferences
    private fun guardarDatos(texto: String, entero: Int, decimal: Float, switchBoleano: Boolean) {
        mSharedPreferences.edit().putInt("miEntero", entero).apply()
        mSharedPreferences.edit().putString("miTexto", texto).apply()
        mSharedPreferences.edit().putFloat("miDecimal", decimal).apply()
        mSharedPreferences.edit().putBoolean("miSwitch", switchBoleano).apply()
    }
}