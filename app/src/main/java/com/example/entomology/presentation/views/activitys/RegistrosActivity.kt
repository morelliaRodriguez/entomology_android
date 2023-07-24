package com.example.entomology.presentation.views.activitys

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.entomology.R
import com.example.entomology.presentation.viewmodels.EntomologoViewModel
import com.example.entomology.presentation.views.fragments.ListaRegistrosFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegistrosActivity : AppCompatActivity() {

    private val viewModelEntomologo by viewModels<EntomologoViewModel>()

    private lateinit var screenSplash : SplashScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registros)

        screenSplash.setKeepOnScreenCondition{true}

        getUserEntomologist()

    }
    private fun getUserEntomologist(){
        lifecycleScope.launch {
            viewModelEntomologo.getEntomology()
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModelEntomologo.uiState.collect{ uiState ->
                    if(!uiState.loading) {
                        screenSplash.setKeepOnScreenCondition { false }
                        if(uiState.msgError != "") {
                            Toast.makeText(this@RegistrosActivity,
                                "El error es: ${uiState.msgError}",
                                Toast.LENGTH_SHORT).show()
                        }
                        else if(uiState.nameEntomology != "") {
                            val inten = Intent(this@RegistrosActivity, RegistroUsuarioActivity::class.java)
                            startActivity(inten)
                        } else {
                            getFragmentListRecords()
                        }

                    }
                }
            }
        }
    }

private fun getFragmentListRecords(){
        supportFragmentManager.beginTransaction()
            .add(R.id.activity_registr, ListaRegistrosFragment()).commit()
    }

}