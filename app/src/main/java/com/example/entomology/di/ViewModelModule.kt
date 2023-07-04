package com.example.entomology.di

import com.example.entomology.domain.repositories.IEntomologyPreferences
import com.example.entomology.presentation.viewmodels.RegistrosViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ViewModelModule {

    @Provides
    fun provideRegistrosViewModel (
        preferencesEntomology : IEntomologyPreferences
    ) : RegistrosViewModel = RegistrosViewModel(preferencesEntomology)
}