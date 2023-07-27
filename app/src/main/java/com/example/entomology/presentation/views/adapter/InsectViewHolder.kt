package com.example.entomology.presentation.views.adapter

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.entomology.databinding.ItemIncectoBinding
import com.example.entomology.domain.models.ModelInsect

class InsectViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemIncectoBinding.bind(view)

    fun bind(item: ModelInsect){
        binding.incectCount.text = if(item.id > 9) item.id.toString() else "0${item.id}"
        binding.txIncet.text = item.speciesName
        binding.imageInsect.setImageURI(Uri.parse(item.urlPhoto))
    }
}