package com.example.entomology.presentation.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.utils.widget.ImageFilterButton
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.entomology.databinding.ActivityRegistroUsuarioBinding

class RegistroUsuarioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroUsuarioBinding

    private lateinit var btnImage: ImageFilterButton
    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnImage= binding.imageFilterButtonUrlPhoto

        screenSplash.setKeepOnScreenCondition{false}

        btnImage.setOnClickListener {
            val intent = Intent(this, SubirFoto::class.java)
            startActivity(intent)
        }
    }
}