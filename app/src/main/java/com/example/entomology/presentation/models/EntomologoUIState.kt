package com.example.entomology.presentation.models

data class EntomologoUIState(

    val loading: Boolean = false,
    val nameEntomology: String = "",
    val urlEntomology: String = "",
    val msgError: String = ""
)