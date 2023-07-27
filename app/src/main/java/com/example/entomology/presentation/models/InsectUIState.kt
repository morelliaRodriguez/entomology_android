package com.example.entomology.presentation.models

import com.example.entomology.domain.models.ModelInsect

data class InsectUIState (

    val listInsect: List<ModelInsect> = listOf(),
    val loading: Boolean = false,
    val msgError: String = ""
    )