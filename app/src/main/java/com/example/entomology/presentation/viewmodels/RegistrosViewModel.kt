package com.example.entomology.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entomology.domain.models.ModelInsect
import com.example.entomology.domain.repositories.IInsectRepository
import com.example.entomology.presentation.models.InsectUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrosViewModel @Inject constructor(
    private val iInsectRepository : IInsectRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(InsectUIState())
    val uiState : StateFlow<InsectUIState> = _uiState.asStateFlow()
    fun getListSpeciesRecords(){
        _uiState.value = uiStateInsect(loading = true)
        viewModelScope.launch {
            val listInsect = iInsectRepository.getListInsectFromDataBase()
            _uiState.value = uiStateInsect(loading = false, listInsect = listInsect)
        }
    }
    fun uiStateInsect(
        listInsect : List<ModelInsect>  = uiState.value.listInsect,
        loading : Boolean = uiState.value.loading,
        error : String = uiState.value.msgError
    ): InsectUIState {
        return InsectUIState( listInsect = listInsect, loading = loading, msgError = error)
    }

}