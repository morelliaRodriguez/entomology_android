package com.example.entomology.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.entomology.domain.repositories.IEntomologyPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrosViewModel @Inject constructor(
    private val entomologyPreferences: IEntomologyPreferences
) : ViewModel() {


}