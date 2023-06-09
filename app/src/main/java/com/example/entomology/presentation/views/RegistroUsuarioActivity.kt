package com.example.entomology.presentation.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.utils.widget.ImageFilterButton
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.entomology.aplication.repository.EntomologyApplication.Companion.sharedPreferences
import com.example.entomology.databinding.ActivityRegistroUsuarioBinding

class RegistroUsuarioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroUsuarioBinding
    private lateinit var btnImage: ImageFilterButton
    private lateinit var btnGuardar: AppCompatButton

    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){
            uri ->
        if (uri!=null){
            binding.imageFilterButtonUrlPhoto.setImageURI(uri)
            sharedPreferences.savePhotoUrl(uri.toString())
        }else
            Log.i("msg","No seleccionada")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkUserValues()
        btnImage= binding.imageFilterButtonUrlPhoto
        btnGuardar= binding.AppCompatButtonGuardar

        screenSplash.setKeepOnScreenCondition{false}

        btnImage.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            //startActivity(Intent(this, SubirFoto::class.java))
        }
        btnGuardar.setOnClickListener {
            validateUser()
            startActivity(Intent(this, RegistroNuevoConteoActivity::class.java))
        }
    }
    fun checkUserValues(){
        if(sharedPreferences.getName().isNotEmpty()){
            startActivity(Intent(this, RegistrosActivity::class.java))
        }
    }
    fun validateUser(){
        if(binding.EditTextUserName.text.toString().isNotEmpty()){
            sharedPreferences.saveName(binding.EditTextUserName.text.toString())
            sharedPreferences.savePhotoUrl(btnImage.toString())

        }else{
            //Hacer otra cosa
        }
    }
}