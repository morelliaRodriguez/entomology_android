package com.example.entomology.domain.repositories

import com.example.entomology.data.local.entity.ModelInsectEntity
import com.example.entomology.domain.models.ModelInsect

interface IInsectRepository {

    suspend fun insertInsect(insect : ModelInsectEntity)

    suspend fun getListInsectFromDataBase() : List<ModelInsect>
}