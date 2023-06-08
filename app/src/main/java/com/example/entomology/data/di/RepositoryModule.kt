package com.example.entomology.data.di

import com.example.entomology.data.local.dao.CountInsectDao
import com.example.entomology.data.local.dao.InsectDao
import com.example.entomology.data.repositories.CountInsectRepository
import com.example.entomology.data.repositories.InsectRepository
import com.example.entomology.domain.repositories.ICountInsectRepository
import com.example.entomology.domain.repositories.IInsectRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideInsectRepository (
        insectDao : InsectDao
    ) : IInsectRepository = InsectRepository(insectDao = insectDao)

    @Provides
    fun provideCountInsectRepository (
        countInsectDao: CountInsectDao
    ) : ICountInsectRepository = CountInsectRepository(countInsectDao)
}