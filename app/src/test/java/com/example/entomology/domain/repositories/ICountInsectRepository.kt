package com.example.entomology.domain.repositories

import com.example.entomology.data.local.entity.ModelCountInsectEntity
import com.example.entomology.domain.models.ModelCountRecord

interface ICountInsectRepository {

    suspend fun insertCountInsect(countInsect : ModelCountInsectEntity)

    suspend fun getListInsectFromDataBase() : List<ModelCountRecord>
}