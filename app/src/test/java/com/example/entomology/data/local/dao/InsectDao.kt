package com.example.entomology.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.entomology.data.local.entity.ModelInsectEntity

@Dao
interface InsectDao {

    @Query("select * from insect")
    suspend fun getAllInsect() : List<ModelInsectEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInsect(insect: ModelInsectEntity)
}