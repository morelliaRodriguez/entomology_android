package com.example.entomology.presentation.views.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.entomology.R
import com.example.entomology.presentation.models.RegistroUIState
import com.example.entomology.presentation.viewmodels.RegistrosViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegistrosActivity : AppCompatActivity() {

    private val viewModelResgistro : RegistrosViewModel by viewModels()
    private lateinit var screenSplash : SplashScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registros)

        getUserEntomologist()
    }

    fun getUserEntomologist(){
        viewModelResgistro.getEntomology()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModelResgistro.uiState.collect{ uiState ->
                    when(uiState){
                        RegistroUIState.Loading -> {
                            screenSplash.setKeepOnScreenCondition{false}
                        }
                        is RegistroUIState.Success -> {
                            Toast.makeText(this@RegistrosActivity,
                                "nombre ${uiState.nameEntomology} y url es: $uiState.urlEntomology",
                                Toast.LENGTH_SHORT).show()

                        }
                    }
                }
            }
        }
    }

}