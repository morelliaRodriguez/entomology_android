package com.example.entomology.presentation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.entomology.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val screenSplash = installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registros)

        screenSplash.setKeepOnScreenCondition{false}
    }
}