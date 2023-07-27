package com.example.entomology.presentation.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.entomology.R
import com.example.entomology.domain.models.ModelInsect

class InsectAdapter (
    private val datosRegistros : List<ModelInsect>
    ) : RecyclerView.Adapter<InsectViewHolder>() {

    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsectViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        return InsectViewHolder(layoutInflater.inflate(R.layout.item_incecto, parent, false))
    }

    override fun getItemCount(): Int = datosRegistros.size

    override fun onBindViewHolder(holder: InsectViewHolder, position: Int) {
        val item = datosRegistros[position]
        holder.bind(item)
    }
}