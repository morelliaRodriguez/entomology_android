package com.example.entomology.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.entomology.data.local.entity.ModelCountInsectEntity

@Dao
interface CountInsectDao {

    @Query("select * from count_insect")
    suspend fun getAllSampleInsect() : List<ModelCountInsectEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountInsect(count_insect:ModelCountInsectEntity)
}