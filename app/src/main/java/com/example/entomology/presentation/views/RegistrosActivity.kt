package com.example.entomology.presentation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.entomology.databinding.ActivityRegistrosBinding
import com.example.entomology.databinding.FragmentNuevoConteoBinding

class RegistrosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrosBinding

    private lateinit var fragment: NuevoConteoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrosBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}