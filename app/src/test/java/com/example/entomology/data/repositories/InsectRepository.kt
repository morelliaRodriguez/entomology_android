package com.example.entomology.data.repositories

import com.example.entomology.data.local.dao.InsectDao
import com.example.entomology.data.local.entity.ModelInsectEntity
import com.example.entomology.domain.models.ModelInsect
import com.example.entomology.domain.models.toDomainModelInsect
import com.example.entomology.domain.repositories.IInsectRepository
import javax.inject.Inject

class InsectRepository @Inject constructor(
    private val insectDao : InsectDao
) : IInsectRepository {

    override suspend fun insertInsect(insect : ModelInsectEntity){
        insectDao.insertInsect(insect)
    }

    override suspend fun getListInsectFromDataBase() : List<ModelInsect>{
        var listInsect = insectDao.getAllInsect()
        return listInsect.map { it.toDomainModelInsect() }
    }
}