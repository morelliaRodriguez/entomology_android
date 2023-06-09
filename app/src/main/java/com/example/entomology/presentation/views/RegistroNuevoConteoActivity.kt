package com.example.entomology.presentation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.entomology.databinding.ActivityRegistroNuevoConteoBinding

class RegistroNuevoConteoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroNuevoConteoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroNuevoConteoBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}