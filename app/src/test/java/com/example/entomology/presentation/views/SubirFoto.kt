package com.example.entomology.presentation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import com.example.entomology.R
import com.example.entomology.databinding.ActivitySubirFotoBinding

class SubirFoto : AppCompatActivity() {
    private lateinit var binding: ActivitySubirFotoBinding

    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){
        uri ->
        if (uri!=null){
            binding.imageViewPhotoUser.setImageURI(uri)
        }else
            Log.i("msg","No seleccionada")
    }

    lateinit var btnImage: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubirFotoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnImage = binding.appCompatButton


        btnImage.setOnClickListener{
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))

        }
    }

}
