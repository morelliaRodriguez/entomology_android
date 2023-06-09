package com.example.entomology.presentation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.example.entomology.databinding.ActivitySubirFotoBinding

class SubirFotoActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubirFotoBinding

    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){
        uri ->
        if (uri!=null){
            binding.imageViewPhotoUser.setImageURI(uri)
            //startActivity(Intent(this, RegistroUsuarioActivity::class.java))
        }else
            Log.i("msg","No seleccionada")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubirFotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.appCompatButton.setOnClickListener{
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))

        }
    }

}
