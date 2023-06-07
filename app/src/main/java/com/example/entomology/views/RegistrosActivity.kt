package com.example.entomology.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.entomology.R
import com.example.entomology.databinding.ActivityRegistrosBinding
import com.example.entomology.databinding.ActivitySubirFotoBinding

class RegistrosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrosBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}