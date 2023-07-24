package com.example.entomology.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entomology.domain.repositories.IEntomologyPreferences
import com.example.entomology.presentation.models.EntomologoUIState
import com.example.entomology.utils.Constants.ERROR_CREATING_ENTOMOLOGIST
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EntomologoViewModel @Inject constructor(
    private val entomologyPreferences: IEntomologyPreferences
) : ViewModel() {

    private val _uiState = MutableStateFlow(EntomologoUIState())
    val uiState : StateFlow<EntomologoUIState> = _uiState.asStateFlow()

    fun getEntomology(){
        _uiState.value = uiStateEntomology(loading = true)
        viewModelScope.launch {
            val userEntomology = entomologyPreferences.getEntomology()
            _uiState.value = uiStateEntomology(loading = false)
            _uiState.value = uiStateEntomology(
                nameEntomology = userEntomology[0], urlEntomology = userEntomology[1])
        }
    }

    fun saveEntomology(name: String, photoUrl: String){
        _uiState.value = uiStateEntomology(loading = true)
        viewModelScope.launch{
            val response = entomologyPreferences.saveEntomology(name, photoUrl)
            if(!response) _uiState.value = uiStateEntomology( error = ERROR_CREATING_ENTOMOLOGIST)
            _uiState.value = uiStateEntomology(loading = false)
        }
    }

    fun uiStateEntomology(
        loading : Boolean = uiState.value.loading,
        nameEntomology : String = uiState.value.nameEntomology,
        urlEntomology : String = uiState.value.urlEntomology,
        error : String = uiState.value.msgError
    ): EntomologoUIState {
        return EntomologoUIState(loading = loading,
            nameEntomology = nameEntomology,
            urlEntomology = urlEntomology, msgError = error)
    }
}