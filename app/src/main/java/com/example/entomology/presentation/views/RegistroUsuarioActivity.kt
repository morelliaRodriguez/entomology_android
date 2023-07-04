package com.example.entomology.presentation.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.utils.widget.ImageFilterButton
import com.example.entomology.databinding.ActivityRegistroUsuarioBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistroUsuarioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroUsuarioBinding
    private lateinit var btnImage: ImageFilterButton
    private lateinit var btnGuardar: AppCompatButton

    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){
            uri ->
        if (uri!=null){
            binding.imageFilterButtonUrlPhoto.setImageURI(uri)
        }else
            Log.i("msg","No seleccionada")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnImage= binding.imageFilterButtonUrlPhoto
        btnGuardar= binding.AppCompatButtonGuardar

        btnImage.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            //startActivity(Intent(this, SubirFoto::class.java))
        }
        btnGuardar.setOnClickListener {
            startActivity(Intent(this, RegistroNuevoConteoActivity::class.java))
        }
    }

}