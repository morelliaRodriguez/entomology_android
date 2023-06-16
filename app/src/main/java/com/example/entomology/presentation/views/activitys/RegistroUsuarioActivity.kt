package com.example.entomology.presentation.views.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.utils.widget.ImageFilterButton
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.entomology.R
import com.example.entomology.aplication.repository.EntomologyApplication.Companion.sharedPreferences
import com.example.entomology.databinding.ActivityRegistroUsuarioBinding
import com.example.entomology.presentation.views.fragments.RegistroUsuarioFragment
import com.example.entomology.presentation.views.fragments.SubirFotoFragment

class RegistroUsuarioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroUsuarioBinding
    private lateinit var btnImage: ImageFilterButton

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
        btnImage = binding.imageFilterButtonUrlPhoto

        screenSplash.setKeepOnScreenCondition{false}

        btnImage.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayoutRegistrarUsuario, SubirFotoFragment())
                .commit()

            //pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))

        }


        supportFragmentManager.beginTransaction()
            .replace(R.id.FrameLayoutRegistrarUsuario, RegistroUsuarioFragment())
            .commit()



    }
}