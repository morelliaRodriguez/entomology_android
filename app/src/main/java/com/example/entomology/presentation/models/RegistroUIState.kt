package com.example.entomology.presentation.models

sealed class RegistroUIState{

    object Loading : RegistroUIState()
    data class Success(
        val nameEntomology: String = "",
        val urlEntomology: String = "") : RegistroUIState()
}