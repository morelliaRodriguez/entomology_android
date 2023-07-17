package com.example.entomology.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entomology.domain.repositories.IEntomologyPreferences
import com.example.entomology.presentation.models.RegistroUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrosViewModel @Inject constructor(
    private val entomologyPreferences: IEntomologyPreferences
) : ViewModel() {

    private val _uiState = MutableStateFlow<RegistroUIState>(RegistroUIState.Loading)
    val uiState : StateFlow<RegistroUIState> = _uiState.asStateFlow()
        fun getEntomology(){
        viewModelScope.launch {
            val userEntomology = entomologyPreferences.getEntomology()
            _uiState.value = RegistroUIState.Success(userEntomology[0], userEntomology[1])
        }
    }
}