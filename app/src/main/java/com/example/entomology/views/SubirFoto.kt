package com.example.entomology.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.entomology.R
import com.example.entomology.databinding.ActivitySubirFotoBinding

class SubirFoto : AppCompatActivity() {
    private lateinit var binding: ActivitySubirFotoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubirFotoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}