package com.example.entomology.data.repositories

import com.example.entomology.data.local.dao.CountInsectDao
import com.example.entomology.data.local.entity.ModelCountInsectEntity
import com.example.entomology.domain.models.ModelCountRecord
import com.example.entomology.domain.models.toDomainModelCountInsect
import com.example.entomology.domain.repositories.ICountInsectRepository
import javax.inject.Inject

class CountInsectRepository @Inject constructor(
    private val countInsectDao: CountInsectDao
) : ICountInsectRepository {

    override suspend fun insertCountInsect(countInsect: ModelCountInsectEntity) {
        countInsectDao.insertCountInsect(countInsect)
    }

    override suspend fun getListInsectFromDataBase(): List<ModelCountRecord> {
        val listInsect = countInsectDao.getAllSampleInsect()
        return listInsect.map { it.toDomainModelCountInsect() }
    }
}